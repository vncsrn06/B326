/* =====================================================
   ELEMENTS
===================================================== */

const claw =
    document.getElementById("claw");

const glass =
    document.querySelector(".glass");

const plushies =
    document.querySelectorAll(".plushie");

const startButton =
    document.getElementById("startGame");

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

const messageModal =
    document.getElementById("messageModal");

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

let gameStarted = false;

let busy = false;

let clawPosition = 50;

let collected = 0;

let carrying = null;

let carryingAnimation = null;


/* =====================================================
   LOVE MESSAGES
===================================================== */

const loveMessages = {

    1:
        "You make my world brighter just by being in it. I hope this little teddy reminds you how special you are to me. 💗",

    2:
        "Every time I think about you, I smile. You have a special place in my heart that nobody else could ever replace. ❤️",

    3:
        "Even the simplest moments become special when I'm with you. Thank you for being someone I can laugh and make memories with. 🥰",

    4:
        "Whenever you need a reminder that you're loved, remember this little teddy and remember me. You mean so much to me. 💕",

    5:
        "You deserve all the happiness in the world. I hope I can always be one of the people who makes you smile. 🌸",

    6:
        "Sometimes I randomly think about you and smile. You're honestly one of my favorite thoughts every day. 💗",

    7:
        "I don't need a perfect life. I just want more memories with you, more laughs, more conversations, and more adventures together. ❤️",

    8:
        "If I could put one hug inside every teddy, this whole machine would be full of hugs just for you. 🧸💞",

    9:
        "You're not just someone I love. You're also someone I genuinely enjoy having in my life. That means more than you know. 💕",

    10:
        "YOU GOT THE FINAL TEDDY! 🎉 But the real prize was never inside this machine. The real prize is having you in my life. I love you so much. ❤️"

};


/* =====================================================
   START
===================================================== */

startButton.addEventListener(
    "click",
    startGame
);


function startGame() {

    gameStarted = true;

    startButton.disabled =
        true;

    startButton.textContent =
        "♥ GAME STARTED ♥";


    messageTitle.textContent =
        "🎮 LET'S PLAY!";


    message.textContent =
        "Move the claw over a teddy and press GRAB! 💗";

}


/* =====================================================
   MOVE LEFT
===================================================== */

leftButton.addEventListener(
    "click",
    moveLeft
);


function moveLeft() {

    if (
        !gameStarted ||
        busy
    ) {
        return;
    }


    clawPosition -= 5;


    if (
        clawPosition < 8
    ) {

        clawPosition = 8;

    }


    updateClaw();

}


/* =====================================================
   MOVE RIGHT
===================================================== */

rightButton.addEventListener(
    "click",
    moveRight
);


function moveRight() {

    if (
        !gameStarted ||
        busy
    ) {
        return;
    }


    clawPosition += 5;


    if (
        clawPosition > 92
    ) {

        clawPosition = 92;

    }


    updateClaw();

}


/* =====================================================
   UPDATE CLAW
===================================================== */

function updateClaw() {

    claw.style.left =
        clawPosition + "%";

}


/* =====================================================
   GET CLOSEST TEDDY
===================================================== */

function getTargetTeddy() {

    const glassRect =
        glass.getBoundingClientRect();


    const clawCenter =
        glassRect.left +
        (
            clawPosition / 100
        ) *
        glassRect.width;


    let target = null;

    let closestDistance =
        Infinity;


    plushies.forEach(
        plushie => {

            if (
                plushie.style.display ===
                "none"
            ) {
                return;
            }


            if (
                plushie.classList.contains(
                    "collected"
                )
            ) {
                return;
            }


            const rect =
                plushie.getBoundingClientRect();


            const center =
                rect.left +
                rect.width / 2;


            const distance =
                Math.abs(
                    center -
                    clawCenter
                );


            if (
                distance <
                closestDistance
            ) {

                closestDistance =
                    distance;

                target =
                    plushie;

            }

        }
    );


    /*
       Player has to be reasonably close.
    */

    if (
        closestDistance > 55
    ) {

        return null;

    }


    return target;

}


/* =====================================================
   GRAB
===================================================== */

grabButton.addEventListener(
    "click",
    grab
);


function grab() {

    if (
        !gameStarted ||
        busy ||
        carrying
    ) {
        return;
    }


    busy = true;


    const target =
        getTargetTeddy();


    /* =========================================
       MISS
    ========================================= */

    if (!target) {

        messageTitle.textContent =
            "😅 MISSED!";


        message.textContent =
            "Move the claw closer to a teddy and try again!";


        claw.classList.add(
            "grabbing"
        );


        setTimeout(() => {

            claw.classList.remove(
                "grabbing"
            );


            busy = false;

        }, 450);


        return;

    }


    /* =========================================
       CLOSE CLAW
    ========================================= */

    claw.classList.add(
        "grabbing"
    );


    messageTitle.textContent =
        "🤏 GRABBING...";


    message.textContent =
        "The claw is grabbing the teddy...";


    /* =========================================
       GO DOWN
    ========================================= */

    claw.style.top =
        "170px";


    /*
       Wait for claw to arrive.
    */

    setTimeout(() => {

        attachTeddy(target);

    }, 750);


    /* =========================================
       GO UP
    ========================================= */

    setTimeout(() => {

        claw.style.top =
            "0";

    }, 1250);


    /*
       Go to prize chute.
    */

    setTimeout(() => {

        claw.style.left =
            "18%";

    }, 1950);


    /*
       Release teddy.
    */

    setTimeout(() => {

        releaseTeddy(
            target
        );

    }, 2600);


    /*
       Finish.
    */

    setTimeout(() => {

        claw.classList.remove(
            "grabbing"
        );


        claw.style.top =
            "0";


        claw.style.left =
            clawPosition + "%";


        busy = false;


    }, 3400);

}


/* =====================================================
   ATTACH TEDDY
===================================================== */

function attachTeddy(
    teddy
) {

    carrying =
        teddy;


    /*
       Remove bottom positioning.
    */

    teddy.style.bottom =
        "auto";


    teddy.style.transition =
        "none";


    /*
       It becomes visually attached
       to the claw.
    */

    carryTeddy();

}


/* =====================================================
   CONTINUOUS TEDDY FOLLOW
===================================================== */

function carryTeddy() {

    if (
        !carrying
    ) {
        return;
    }


    const glassRect =
        glass.getBoundingClientRect();


    const clawRect =
        claw.getBoundingClientRect();


    /*
       Calculate teddy position
       based on current claw position.
    */

    const teddyWidth =
        carrying.offsetWidth;


    const teddyHeight =
        carrying.offsetHeight;


    const left =
        clawRect.left -
        glassRect.left +
        (
            clawRect.width -
            teddyWidth
        ) / 2;


    const top =
        clawRect.top -
        glassRect.top +
        105;


    carrying.style.left =
        left + "px";


    carrying.style.top =
        top + "px";


    carryingAnimation =
        requestAnimationFrame(
            carryTeddy
        );

}


/* =====================================================
   RELEASE TEDDY
===================================================== */

function releaseTeddy(
    teddy
) {

    /*
       Stop continuous following.
    */

    carrying = null;


    if (
        carryingAnimation
    ) {

        cancelAnimationFrame(
            carryingAnimation
        );

        carryingAnimation =
            null;

    }


    /*
       Get prize chute.
    */

    const chute =
        document.querySelector(
            ".prize-chute"
        );


    const glassRect =
        glass.getBoundingClientRect();


    const chuteRect =
        chute.getBoundingClientRect();


    /*
       Current teddy position.
    */

    const currentRect =
        teddy.getBoundingClientRect();


    const currentLeft =
        currentRect.left -
        glassRect.left;


    const currentTop =
        currentRect.top -
        glassRect.top;


    /*
       Target position.
    */

    const targetLeft =
        chuteRect.left -
        glassRect.left +
        (
            chuteRect.width -
            teddy.offsetWidth
        ) / 2;


    const targetTop =
        chuteRect.top -
        glassRect.top -
        55;


    /*
       Put teddy back into glass.
    */

    glass.appendChild(
        teddy
    );


    teddy.style.position =
        "absolute";


    teddy.style.left =
        currentLeft + "px";


    teddy.style.top =
        currentTop + "px";


    teddy.style.bottom =
        "auto";


    teddy.style.transition =
        "none";


    teddy.style.transform =
        "none";


    /*
       Force starting position.
    */

    void teddy.offsetWidth;


    /*
       Move smoothly above prize chute.
    */

    teddy.style.transition =
        "left .45s ease-out, top .45s ease-out";


    teddy.style.left =
        targetLeft + "px";


    teddy.style.top =
        targetTop + "px";


    /*
       Drop.
    */

    setTimeout(() => {

        teddy.classList.add(
            "falling"
        );


        teddy.style.transition =
            "top .65s cubic-bezier(.15,.8,.3,1)";


        teddy.style.top =
            (
                targetTop +
                62
            ) + "px";


    }, 450);


    /*
       Count.
    */

    collected++;

    count.textContent =
        collected;


    /*
       Show basic message.
    */

    const id =
        teddy.dataset.id;


    messageTitle.textContent =
        "🧸 TEDDY #" + id;


    message.textContent =
        "Your teddy is waiting for you! Open it for a message. 💗";


    /*
       Open the message automatically
       after the teddy lands.
    */

    setTimeout(() => {

        openMessage(id);

    }, 1150);

}


/* =====================================================
   OPEN TEDDY MESSAGE
===================================================== */

function openMessage(
    id
) {

    modalTeddy.textContent =
        getTeddyEmoji(id);


    modalTitle.textContent =
        "💗 Teddy #" + id;


    modalMessage.textContent =
        loveMessages[id];


    messageModal.classList.remove(
        "hidden"
    );


    createHearts();

}


/* =====================================================
   CLOSE MESSAGE
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

    messageModal.classList.add(
        "hidden"
    );


    /*
       Final message.
    */

    if (
        collected === 10
    ) {

        showFinal();

    }

}


/* =====================================================
   TEDDY EMOJI
===================================================== */

function getTeddyEmoji(
    id
) {

    const teddies = [

        "🧸",
        "🧸",
        "🧸",
        "🧸",
        "🧸",
        "🧸",
        "🧸",
        "🧸",
        "🧸",
        "🧸"

    ];


    return teddies[id - 1];

}


/* =====================================================
   FINAL
===================================================== */

function showFinal() {

    messageTitle.textContent =
        "🎉 ALL 10 TEDDIES!";


    message.textContent =
        "You opened every little message. " +
        "But the biggest prize isn't inside the machine. " +
        "It's having you in my life. ❤️";


    createManyHearts();

}


/* =====================================================
   HEARTS
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


        heart.textContent =
            "♥";


        heart.style.position =
            "fixed";


        heart.style.left =
            (
                15 +
                Math.random() * 70
            ) + "%";


        heart.style.top =
            (
                45 +
                Math.random() * 30
            ) + "%";


        heart.style.color =
            "#ff6f9f";


        heart.style.fontSize =
            (
                16 +
                Math.random() * 18
            ) + "px";


        heart.style.zIndex =
            "9999";


        heart.style.pointerEvents =
            "none";


        document.body.appendChild(
            heart
        );


        const animation =
            heart.animate(

                [

                    {
                        transform:
                            "translateY(0) scale(1)",

                        opacity: 1

                    },

                    {

                        transform:
                            "translateY(-140px) scale(1.4)",

                        opacity: 0

                    }

                ],

                {

                    duration:
                        900 +
                        Math.random() * 500,

                    easing:
                        "ease-out"

                }

            );


        animation.onfinish =
            () => {

                heart.remove();

            };

    }

}


/* =====================================================
   MANY HEARTS
===================================================== */

function createManyHearts() {

    for (
        let i = 0;
        i < 5;
        i++
    ) {

        setTimeout(
            createHearts,
            i * 200
        );

    }

}


/* =====================================================
   KEYBOARD
===================================================== */

document.addEventListener(
    "keydown",
    event => {

        if (
            event.key ===
            "ArrowLeft"
        ) {

            event.preventDefault();

            moveLeft();

        }


        if (
            event.key ===
            "ArrowRight"
        ) {

            event.preventDefault();

            moveRight();

        }


        if (
            event.code ===
            "Space"
        ) {

            event.preventDefault();

            grab();

        }

    }
);