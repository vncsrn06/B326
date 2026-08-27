/* =====================================================
   ELEMENTS
===================================================== */

const glass =
    document.getElementById("glass");

const playfield =
    document.getElementById("playfield");

const claw =
    document.getElementById("claw");

const prizeChute =
    document.getElementById("prizeChute");

const teddies =
    [...document.querySelectorAll(".teddy")];

const startButton =
    document.getElementById("startButton");

const leftButton =
    document.getElementById("leftButton");

const rightButton =
    document.getElementById("rightButton");

const grabButton =
    document.getElementById("grabButton");

const messageTitle =
    document.getElementById("messageTitle");

const message =
    document.getElementById("message");

const count =
    document.getElementById("count");

const modal =
    document.getElementById("messageModal");

const modalImage =
    document.getElementById("modalImage");

const modalTeddy =
    document.getElementById("modalTeddy");

const modalTitle =
    document.getElementById("modalTitle");

const modalMessage =
    document.getElementById("modalMessage");

const closeModal =
    document.getElementById("closeModal");

const continueButton =
    document.getElementById("continueButton");


/* =====================================================
   GAME STATE
===================================================== */

let gameStarted =
    false;

let state =
    "idle";

let clawX =
    0;

let clawY =
    0;

let selectedTeddy =
    null;

let waitingTeddy =
    null;

let openedCount =
    0;

let carrying =
    false;


/*
    Set keeps track of collected
    teddy IDs.
*/

const collectedTeddies =
    new Set();


/* =====================================================
   LOVE MESSAGES
===================================================== */

const loveMessages = {

    1:
        "You make my world brighter just by being in it. I hope this little teddy reminds you how special you are to me. 💗",

    2:
        "Every time I think about you, I smile. You have such a special place in my heart. ❤️",

    3:
        "Even ordinary moments become special when I'm with you. Thank you for all the memories we keep making together. 🥰",

    4:
        "Whenever you need a reminder that you're loved, remember this little teddy and remember me. 💕",

    5:
        "You deserve all the happiness in the world. I hope I can always be one of the reasons you smile. 🌸",

    6:
        "Sometimes I randomly think about you and smile. You're honestly one of my favorite thoughts every day. 💗",

    7:
        "I don't need a perfect life. I just want more memories with you — more laughs, talks and adventures together. ❤️",

    8:
        "If I could put one hug inside every teddy, this whole machine would be full of hugs for you. 🧸💞",

    9:
        "You're not just someone I love. You're someone I genuinely enjoy having in my life. 💕",

    10:
        "YOU GOT THE FINAL TEDDY! 🎉 But the real prize was never inside this machine. The real prize is having you in my life. I love you so much. ❤️"

};


/* =====================================================
   START GAME
===================================================== */

startButton.addEventListener(
    "click",
    startGame
);


function startGame() {

    gameStarted =
        true;

    state =
        "idle";

    clawX =
        playfield.clientWidth / 2;

    clawY =
        0;

    setClawX(
        clawX
    );

    setClawY(
        clawY
    );

    startButton.disabled =
        true;

    startButton.textContent =
        "♥ GAME STARTED ♥";

    leftButton.disabled =
        false;

    rightButton.disabled =
        false;

    grabButton.disabled =
        false;

    messageTitle.textContent =
        "🎮 LET'S PLAY!";

    message.textContent =
        "Move the claw over a teddy and press GRAB!";

}


/* =====================================================
   CLAW X
===================================================== */

function setClawX(
    x
) {

    const half =
        claw.offsetWidth / 2;

    const maximum =
        playfield.clientWidth -
        half;


    clawX =
        Math.max(
            half,
            Math.min(
                maximum,
                x
            )
        );


    claw.style.left =
        clawX + "px";

}


/* =====================================================
   CLAW Y
===================================================== */

function setClawY(
    y
) {

    clawY =
        Math.max(
            0,
            y
        );


    claw.style.top =
        clawY + "px";


    updateCarriedTeddy();

}


/* =====================================================
   LEFT BUTTON
===================================================== */

leftButton.addEventListener(
    "click",
    () => {

        if (
            state !==
            "idle"
        ) {

            return;

        }


        setClawX(
            clawX - 20
        );


        bumpNearbyTeddies();

    }
);


/* =====================================================
   RIGHT BUTTON
===================================================== */

rightButton.addEventListener(
    "click",
    () => {

        if (
            state !==
            "idle"
        ) {

            return;

        }


        setClawX(
            clawX + 20
        );


        bumpNearbyTeddies();

    }
);


/* =====================================================
   KEYBOARD
===================================================== */

document.addEventListener(
    "keydown",
    event => {

        if (
            !gameStarted
        ) {

            return;

        }


        if (
            event.key ===
            "ArrowLeft"
        ) {

            event.preventDefault();

            leftButton.click();

        }


        if (
            event.key ===
            "ArrowRight"
        ) {

            event.preventDefault();

            rightButton.click();

        }


        if (
            event.code ===
            "Space"
        ) {

            event.preventDefault();

            if (
                state ===
                "idle"
            ) {

                grabTeddy();

            }

        }

    }
);


/* =====================================================
   FIND RANDOM TEDDY
===================================================== */

function findRandomTeddy() {

    const available =
        teddies.filter(
            teddy => {

                const id =
                    Number(
                        teddy.dataset.id
                    );


                return (
                    !collectedTeddies.has(id) &&
                    teddy !== waitingTeddy &&
                    teddy !== selectedTeddy &&
                    teddy.style.display !== "none"
                );

            }
        );


    if (
        available.length ===
        0
    ) {

        return null;

    }


    /*
        RANDOM ORDER

        Picks any remaining teddy.
    */

    const randomIndex =
        Math.floor(
            Math.random() *
            available.length
        );


    return available[randomIndex];

}


/* =====================================================
   GRAB BUTTON
===================================================== */

grabButton.addEventListener(
    "click",
    grabTeddy
);


/* =====================================================
   GRAB TEDDY
===================================================== */

function grabTeddy() {

    if (
        !gameStarted ||
        state !== "idle" ||
        waitingTeddy ||
        carrying
    ) {

        return;

    }


    const teddy =
        findRandomTeddy();


    if (
        !teddy
    ) {

        finishGame();

        return;

    }


    selectedTeddy =
        teddy;


    state =
        "lowering";


    claw.classList.add(
        "grabbing"
    );


    messageTitle.textContent =
        "🤏 GRABBING...";


    message.textContent =
        "The claw is reaching for a teddy...";


    /*
        Determine teddy position
        relative to the glass.
    */

    const teddyRect =
        teddy.getBoundingClientRect();

    const glassRect =
        glass.getBoundingClientRect();


    const teddyY =
        teddyRect.top -
        glassRect.top;


    /*
        Bring claw down.
    */

    const targetY =
        Math.max(
            25,
            Math.min(
                205,
                teddyY -
                105
            )
        );


    animate(
        clawY,
        targetY,
        700,

        value => {

            setClawY(
                value
            );

        },

        () => {

            captureTeddy();

        }

    );

}


/* =====================================================
   CAPTURE TEDDY
===================================================== */

function captureTeddy() {

    if (
        !selectedTeddy
    ) {

        resetRound();

        return;

    }


    const teddy =
        selectedTeddy;


    /*
        IMPORTANT:

        Move teddy directly into
        the glass.

        This allows it to sit above
        the prize chute later.
    */

    const oldRect =
        teddy.getBoundingClientRect();


    glass.appendChild(
        teddy
    );


    const glassRect =
        glass.getBoundingClientRect();


    teddy.style.position =
        "absolute";


    teddy.style.left =
        (
            oldRect.left -
            glassRect.left
        ) + "px";


    teddy.style.top =
        (
            oldRect.top -
            glassRect.top
        ) + "px";


    teddy.style.bottom =
        "auto";


    teddy.style.zIndex =
        "2200";


    teddy.style.pointerEvents =
        "none";


    carrying =
        true;


    state =
        "grabbing";


    updateCarriedTeddy();


    messageTitle.textContent =
        "🧸 GOT IT!";


    message.textContent =
        "YES! The claw caught your teddy! 💗";


    /*
        Tiny pause so the grab
        feels physical.
    */

    setTimeout(
        () => {

            if (
                !selectedTeddy
            ) {

                return;

            }


            state =
                "lifting";


            animate(
                clawY,
                0,
                750,

                value => {

                    setClawY(
                        value
                    );

                },

                () => {

                    moveToChute();

                }

            );

        },
        180
    );

}


/* =====================================================
   UPDATE CARRIED TEDDY
===================================================== */

function updateCarriedTeddy() {

    if (
        !selectedTeddy ||
        !carrying
    ) {

        return;

    }


    const teddy =
        selectedTeddy;


    const clawRect =
        claw.getBoundingClientRect();

    const glassRect =
        glass.getBoundingClientRect();


    /*
        Teddy stays directly
        underneath claw.
    */

    const x =
        clawRect.left -
        glassRect.left +
        (
            clawRect.width -
            teddy.offsetWidth
        ) / 2;


    const y =
        clawRect.top -
        glassRect.top +
        104;


    teddy.style.left =
        x + "px";


    teddy.style.top =
        y + "px";


    teddy.style.transform =
        "none";

}


/* =====================================================
   CARRY LOOP
===================================================== */

function carryLoop() {

    if (
        carrying
    ) {

        updateCarriedTeddy();

    }


    requestAnimationFrame(
        carryLoop
    );

}


requestAnimationFrame(
    carryLoop
);


/* =====================================================
   MOVE TO CHUTE
===================================================== */

function moveToChute() {

    if (
        !selectedTeddy
    ) {

        resetRound();

        return;

    }


    state =
        "moving";


    messageTitle.textContent =
        "🎁 GOING TO THE CHUTE";


    message.textContent =
        "Watch your teddy travel to the prize chute!";


    /*
        Center of chute.
    */

    const chuteCenter =
        prizeChute.offsetLeft +
        prizeChute.offsetWidth / 2;


    animate(
        clawX,
        chuteCenter,
        800,

        value => {

            setClawXWithoutBump(
                value
            );


            updateCarriedTeddy();

        },

        () => {

            releaseTeddy();

        }

    );

}


/* =====================================================
   CLAW WITHOUT BUMPING
===================================================== */

function setClawXWithoutBump(
    x
) {

    const half =
        claw.offsetWidth / 2;

    const maximum =
        playfield.clientWidth -
        half;


    clawX =
        Math.max(
            half,
            Math.min(
                maximum,
                x
            )
        );


    claw.style.left =
        clawX + "px";


    updateCarriedTeddy();

}


/* =====================================================
   RELEASE
===================================================== */

function releaseTeddy() {

    if (
        !selectedTeddy
    ) {

        resetRound();

        return;

    }


    const teddy =
        selectedTeddy;


    /*
        Detach.
    */

    selectedTeddy =
        null;


    carrying =
        false;


    state =
        "dropping";


    /*
        Chute center.
    */

    const chuteCenter =
        prizeChute.offsetLeft +
        prizeChute.offsetWidth / 2;


    /*
        START HIGH.

        This is intentionally high
        so you can SEE the teddy fall.
    */

    let x =
        chuteCenter -
        teddy.offsetWidth / 2;


    let y =
        prizeChute.offsetTop -
        teddy.offsetHeight -
        125;


    let velocity =
        0;


    /*
        Physics.
    */

    const gravity =
        1500;


    const bounce =
        0.34;


    let bounceCount =
        0;


    let previousTime =
        performance.now();


    teddy.style.left =
        x + "px";


    teddy.style.top =
        y + "px";


    teddy.style.zIndex =
        "3000";


    teddy.style.pointerEvents =
        "none";


    teddy.classList.remove(
        "in-chute"
    );


    messageTitle.textContent =
        "⬇️ DROP!";


    message.textContent =
        "Watch your teddy fall into the prize chute!";


    /*
        PHYSICS LOOP
    */

    function frame(
        now
    ) {

        const dt =
            Math.min(
                .03,
                (
                    now -
                    previousTime
                ) / 1000
            );


        previousTime =
            now;


        /*
            Gravity.
        */

        velocity +=
            gravity *
            dt;


        /*
            Fall.
        */

        y +=
            velocity *
            dt;


        /*
            Slight rotation.
        */

        const rotation =
            Math.sin(
                now * .012
            ) *
            Math.min(
                8,
                Math.abs(
                    velocity
                ) / 50
            );


        teddy.style.transform =
            `rotate(${rotation}deg)`;


        /*
            Landing area.

            Teddy remains visible in
            front of the chute.
        */

        const landingY =
            prizeChute.offsetTop -
            teddy.offsetHeight +
            28;


        /*
            Collision.
        */

        if (
            y >=
            landingY
        ) {

            y =
                landingY;


            /*
                Bounce.
            */

            velocity =
                -velocity *
                bounce;


            bounceCount++;


            /*
                Stop after small
                final bounces.
            */

            if (
                Math.abs(
                    velocity
                ) < 65 ||
                bounceCount >= 4
            ) {

                velocity =
                    0;


                /*
                    Center teddy.
                */

                x =
                    chuteCenter -
                    teddy.offsetWidth / 2;


                y =
                    landingY;


                teddy.style.left =
                    x + "px";


                teddy.style.top =
                    y + "px";


                teddy.style.transform =
                    "none";


                /*
                    MAKE CLICKABLE.
                */

                teddy.classList.add(
                    "in-chute"
                );


                teddy.style.zIndex =
                    "3000";


                teddy.style.pointerEvents =
                    "auto";


                waitingTeddy =
                    teddy;


                state =
                    "waiting";


                messageTitle.textContent =
                    "🎁 YOUR TEDDY ARRIVED!";


                message.textContent =
                    "Click the teddy in the prize chute to open your message! 💗";


                createHearts();


                return;

            }

        }


        /*
            Continue.
        */

        teddy.style.left =
            x + "px";


        teddy.style.top =
            y + "px";


        requestAnimationFrame(
            frame
        );

    }


    requestAnimationFrame(
        frame
    );

}


/* =====================================================
   CLICK PRIZE TEDDY
===================================================== */

teddies.forEach(
    teddy => {

        teddy.addEventListener(
            "click",
            () => {

                if (
                    teddy !==
                    waitingTeddy
                ) {

                    return;

                }


                openPrize(
                    teddy
                );

            }
        );

    }
);


/* =====================================================
   OPEN PRIZE
===================================================== */

function openPrize(
    teddy
) {

    const id =
        Number(
            teddy.dataset.id
        );


    /*
        Record teddy.
    */

    collectedTeddies.add(
        id
    );


    waitingTeddy =
        null;


    teddy.style.pointerEvents =
        "none";


    teddy.classList.remove(
        "in-chute"
    );


    teddy.style.display =
        "none";


    openedCount++;


    count.textContent =
        openedCount;


    state =
        "message";


    /*
        =====================================
        NORMAL TEDDY
    ===================================== */

    if (
        openedCount <
        10
    ) {

        modalImage.src =
            "pictures/teddy" +
            id +
            ".jpg";


        modalImage.alt =
            "Teddy " +
            id;


        modalTeddy.textContent =
            "🧸";


        modalTitle.textContent =
            "💗 TEDDY #" +
            id;


        modalMessage.textContent =
            loveMessages[id];

    }


    /*
        =====================================
        FINAL TEDDY
    ===================================== */

    else {

        modalImage.src =
            "pictures/teddy" +
            id +
            ".jpg";


        modalImage.alt =
            "Final memory";


        modalTeddy.textContent =
            "🧸💗🧸";


        modalTitle.textContent =
            "🎉 ALL 10 TEDDIES! 🎉";


        modalMessage.textContent =
            "YOU GOT THEM ALL! Every single teddy had a little message for you, but the best prize is still you. Thank you for being such a special part of my life. I love you so much. ❤️🧸";

    }


    /*
        Show modal.
    */

    modal.classList.remove(
        "hidden"
    );


    /*
        Teddy animation.
    */

    modalTeddy.style.animation =
        "none";


    void modalTeddy.offsetWidth;


    modalTeddy.style.animation =
        "modalTeddy .6s ease-out";


    createHearts();


    /*
        Extra final hearts.
    */

    if (
        openedCount >=
        10
    ) {

        setTimeout(
            createManyHearts,
            250
        );

    }

}


/* =====================================================
   CLOSE MODAL
===================================================== */

closeModal.addEventListener(
    "click",
    closeMessage
);


continueButton.addEventListener(
    "click",
    closeMessage
);


function closeMessage() {

    modal.classList.add(
        "hidden"
    );


    claw.classList.remove(
        "grabbing"
    );


    /*
        ALL 10
    */

    if (
        collectedTeddies.size >=
        10
    ) {

        finishGame();

        return;

    }


    /*
        NEXT RANDOM TEDDY
    */

    state =
        "idle";


    selectedTeddy =
        null;


    waitingTeddy =
        null;


    carrying =
        false;


    setClawY(
        0
    );


    messageTitle.textContent =
        "🎮 NEXT RANDOM TEDDY!";


    message.textContent =
        "Which teddy will you get next? Move the claw and grab one! 🧸";


    leftButton.disabled =
        false;


    rightButton.disabled =
        false;


    grabButton.disabled =
        false;

}


/* =====================================================
   FINISH
===================================================== */

function finishGame() {

    state =
        "finished";


    selectedTeddy =
        null;


    waitingTeddy =
        null;


    carrying =
        false;


    claw.classList.remove(
        "grabbing"
    );


    leftButton.disabled =
        true;


    rightButton.disabled =
        true;


    grabButton.disabled =
        true;


    messageTitle.textContent =
        "🎉 ALL 10 TEDDIES ARE COLLECTED!";


    message.textContent =
        "You found every single teddy! ❤️";


    createManyHearts();

}


/* =====================================================
   MISS
===================================================== */

function showMiss() {

    messageTitle.textContent =
        "😅 MISSED!";


    message.textContent =
        "Move the claw closer to a teddy and try again!";


    claw.classList.add(
        "grabbing"
    );


    setTimeout(
        () => {

            claw.classList.remove(
                "grabbing"
            );

        },
        250
    );

}


/* =====================================================
   NEARBY TEDDY WOBBLE
===================================================== */

function bumpNearbyTeddies() {

    if (
        state !==
        "idle"
    ) {

        return;

    }


    const clawRect =
        claw.getBoundingClientRect();


    const clawCenter =
        clawRect.left +
        clawRect.width / 2;


    teddies.forEach(
        teddy => {

            const id =
                Number(
                    teddy.dataset.id
                );


            if (
                collectedTeddies.has(
                    id
                )
            ) {

                return;

            }


            if (
                teddy ===
                waitingTeddy
            ) {

                return;

            }


            const rect =
                teddy.getBoundingClientRect();


            const teddyCenter =
                rect.left +
                rect.width / 2;


            const distance =
                Math.abs(
                    teddyCenter -
                    clawCenter
                );


            /*
                When claw gets very close,
                teddy wobbles.
            */

            if (
                distance <
                40
            ) {

                teddy.animate(

                    [

                        {
                            transform:
                                "translateX(0) rotate(0)"
                        },

                        {
                            transform:
                                teddyCenter <
                                clawCenter
                                    ? "translateX(-5px) rotate(-2deg)"
                                    : "translateX(5px) rotate(2deg)"
                        },

                        {
                            transform:
                                "translateX(0) rotate(0)"
                        }

                    ],

                    {

                        duration:
                            220,

                        easing:
                            "ease-out"

                    }

                );

            }

        }
    );

}


/* =====================================================
   SMOOTH ANIMATION
===================================================== */

function animate(
    from,
    to,
    duration,
    update,
    complete
) {

    const start =
        performance.now();


    function frame(
        now
    ) {

        const progress =
            Math.min(
                1,
                (
                    now -
                    start
                ) /
                duration
            );


        const eased =
            easeInOutCubic(
                progress
            );


        const value =
            from +
            (
                to -
                from
            ) *
            eased;


        update(
            value
        );


        if (
            progress <
            1
        ) {

            requestAnimationFrame(
                frame
            );

        }

        else {

            if (
                complete
            ) {

                complete();

            }

        }

    }


    requestAnimationFrame(
        frame
    );

}


/* =====================================================
   EASING
===================================================== */

function easeInOutCubic(
    t
) {

    if (
        t <
        0.5
    ) {

        return 4 *
            t *
            t *
            t;

    }


    return 1 -
        Math.pow(
            -2 *
            t +
            2,
            3
        ) /
        2;

}


/* =====================================================
   HEART EFFECT
===================================================== */

function createHearts() {

    for (
        let i = 0;
        i < 10;
        i++
    ) {

        const heart =
            document.createElement(
                "div"
            );


        heart.className =
            "heart-particle";


        heart.textContent =
            i % 2 === 0
                ? "♥"
                : "♡";


        heart.style.left =
            (
                15 +
                Math.random() *
                70
            ) + "%";


        heart.style.top =
            (
                40 +
                Math.random() *
                30
            ) + "%";


        document.body.appendChild(
            heart
        );


        requestAnimationFrame(
            () => {

                heart.classList.add(
                    "animate"
                );

            }
        );


        setTimeout(
            () => {

                heart.remove();

            },
            1300
        );

    }

}


/* =====================================================
   MANY HEARTS
===================================================== */

function createManyHearts() {

    for (
        let i = 0;
        i < 6;
        i++
    ) {

        setTimeout(
            createHearts,
            i * 180
        );

    }

}