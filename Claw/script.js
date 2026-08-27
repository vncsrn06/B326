/* =====================================================
   ELEMENTS
===================================================== */

const glass =
    document.getElementById("glass");

const claw =
    document.getElementById("claw");

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
    document.getElementById(
        "continueButton"
    );


/* =====================================================
   GAME STATE
===================================================== */

let gameStarted = false;

let busy = false;

let clawPosition = 50;

let collected = 0;

let carriedTeddy = null;

let carryAnimation = null;


/* =====================================================
   TEDDY PICTURES
===================================================== */

const teddyPictures = {

    1: "pictures/teddy1.jpg",

    2: "pictures/teddy2.jpg",

    3: "pictures/teddy3.jpg",

    4: "pictures/teddy4.jpg",

    5: "pictures/teddy5.jpg",

    6: "pictures/teddy6.jpg",

    7: "pictures/teddy7.jpg",

    8: "pictures/teddy8.jpg",

    9: "pictures/teddy9.jpg",

    10: "pictures/teddy10.jpg"

};


/* =====================================================
   LOVE MESSAGES
===================================================== */

const loveMessages = {

    1:
        "You make my world brighter just by being in it. I hope this little teddy reminds you how special you are to me. 💗",

    2:
        "Every time I think about you, I smile. You have a place in my heart that nobody else could ever replace. ❤️",

    3:
        "Even ordinary days feel special when I'm with you. Thank you for all the little moments we share. 🥰",

    4:
        "Whenever you need a reminder that you're loved, remember this little teddy and remember me. 💕",

    5:
        "You deserve all the happiness in the world. I hope I can always be one of the people who makes you smile. 🌸",

    6:
        "Sometimes I randomly think about you and smile. You're honestly one of my favorite thoughts every day. 💗",

    7:
        "I don't need a perfect life. I just want more memories with you, more laughs, more conversations, and more adventures together. ❤️",

    8:
        "If I could put one hug inside every teddy, this whole machine would be full of hugs just for you. 🧸💞",

    9:
        "You're not just someone I love. You're someone I genuinely enjoy having in my life. That means more than you know. 💕",

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

    gameStarted = true;

    startButton.disabled =
        true;

    startButton.textContent =
        "♥ GAME STARTED ♥";


    messageTitle.textContent =
        "🎮 LET'S PLAY!";


    message.textContent =
        "Move the claw over a teddy and press GRAB! 💗";


    leftButton.disabled =
        false;

    rightButton.disabled =
        false;

    grabButton.disabled =
        false;

}


/* =====================================================
   UPDATE CLAW
===================================================== */

function updateClaw() {

    claw.style.left =
        clawPosition + "%";

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
        busy ||
        collected >= 10
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
        busy ||
        collected >= 10
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
   FIND TEDDY
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
        teddy => {

            if (
                teddy.style.display ===
                "none"
            ) {

                return;

            }


            if (
                teddy.dataset.collected ===
                "true"
            ) {

                return;

            }


            const teddyRect =
                teddy.getBoundingClientRect();


            const teddyCenter =
                teddyRect.left +
                teddyRect.width / 2;


            const distance =
                Math.abs(
                    teddyCenter -
                    clawCenter
                );


            if (
                distance <
                closestDistance
            ) {

                closestDistance =
                    distance;

                target =
                    teddy;

            }

        }
    );


    /*
        Player must be close enough.
    */

    if (
        closestDistance > 55
    ) {

        return null;

    }


    return target;

}


/* =====================================================
   GRAB BUTTON
===================================================== */

grabButton.addEventListener(
    "click",
    grabTeddy
);


function grabTeddy() {

    if (
        !gameStarted ||
        busy ||
        carriedTeddy
    ) {

        return;

    }


    if (
        collected >= 10
    ) {

        return;

    }


    busy = true;


    const target =
        getTargetTeddy();


    /* =================================================
       MISS
    ================================================= */

    if (!target) {

        messageTitle.textContent =
            "😅 MISSED!";


        message.textContent =
            "Move the claw directly over a teddy and try again!";


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


    /* =================================================
       CLOSE CLAW
    ================================================= */

    claw.classList.add(
        "grabbing"
    );


    messageTitle.textContent =
        "🤏 GRABBING...";


    message.textContent =
        "The claw is grabbing the teddy... 💗";


    /* =================================================
       GO DOWN
    ================================================= */

    claw.style.top =
        "170px";


    /*
       Wait for claw to reach teddy.
    */

    setTimeout(() => {

        attachTeddy(
            target
        );

    }, 750);


    /* =================================================
       GO UP
    ================================================= */

    setTimeout(() => {

        claw.style.top =
            "0";

        messageTitle.textContent =
            "🧸 GOT IT!";

        message.textContent =
            "Don't drop it! We're taking it to the prize chute. 💕";

    }, 1250);


    /* =================================================
       MOVE TO PRIZE CHUTE
    ================================================= */

    setTimeout(() => {

        claw.style.left =
            "18%";

    }, 1900);


    /* =================================================
       DROP
    ================================================= */

    setTimeout(() => {

        releaseTeddy(
            target
        );

    }, 2600);


    /* =================================================
       RESET
    ================================================= */

    setTimeout(() => {

        claw.classList.remove(
            "grabbing"
        );


        claw.style.top =
            "0";


        claw.style.left =
            clawPosition + "%";


        busy = false;

    }, 3600);

}


/* =====================================================
   ATTACH TEDDY
===================================================== */

function attachTeddy(
    teddy
) {

    carriedTeddy =
        teddy;


    teddy.classList.add(
        "carried"
    );


    /*
       Remove its old bottom positioning.
    */

    teddy.style.bottom =
        "auto";


    /*
       Continue following claw.
    */

    followClaw();

}


/* =====================================================
   TEDDY FOLLOWS CLAW
===================================================== */

function followClaw() {

    if (
        !carriedTeddy
    ) {

        return;

    }


    const glassRect =
        glass.getBoundingClientRect();


    const clawRect =
        claw.getBoundingClientRect();


    const teddyWidth =
        carriedTeddy.offsetWidth;


    /*
       Horizontal center
    */

    const teddyLeft =
        clawRect.left -
        glassRect.left +
        (
            clawRect.width -
            teddyWidth
        ) / 2;


    /*
       Teddy stays underneath
       the claw head.
    */

    const teddyTop =
        clawRect.top -
        glassRect.top +
        115;


    carriedTeddy.style.left =
        teddyLeft + "px";


    carriedTeddy.style.top =
        teddyTop + "px";


    carriedTeddy.style.transform =
        "none";


    carryAnimation =
        requestAnimationFrame(
            followClaw
        );

}


/* =====================================================
   RELEASE TEDDY
===================================================== */

function releaseTeddy(
    teddy
) {

    /*
       Stop follow animation.
    */

    if (
        carryAnimation
    ) {

        cancelAnimationFrame(
            carryAnimation
        );

        carryAnimation =
            null;

    }


    carriedTeddy =
        null;


    /*
       Get chute coordinates.
    */

    const chute =
        document.getElementById(
            "prizeChute"
        );


    const glassRect =
        glass.getBoundingClientRect();


    const chuteRect =
        chute.getBoundingClientRect();


    /*
       Current teddy screen location.
    */

    const teddyRect =
        teddy.getBoundingClientRect();


    const currentLeft =
        teddyRect.left -
        glassRect.left;


    const currentTop =
        teddyRect.top -
        glassRect.top;


    /*
       Put teddy inside glass.
    */

    teddy.classList.remove(
        "carried"
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
       Target position above chute.
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
        65;


    /*
       Move toward chute.
    */

    void teddy.offsetWidth;


    teddy.style.transition =
        "left .4s ease-out, top .4s ease-out";


    teddy.style.left =
        targetLeft + "px";


    teddy.style.top =
        targetTop + "px";


    /*
       Drop after reaching chute.
    */

    setTimeout(() => {

        teddy.style.transition =
            "top .7s cubic-bezier(.18,.75,.28,1)";


        teddy.classList.add(
            "drop-animation"
        );


        teddy.style.top =
            (
                targetTop +
                55
            ) + "px";


    }, 450);


    /*
       Mark collected.
    */

    teddy.dataset.collected =
        "true";


    /*
       Count.
    */

    collected++;

    count.textContent =
        collected;


    /*
       Hide after landing.
    */

    setTimeout(() => {

        teddy.style.opacity =
            "0";


        teddy.style.pointerEvents =
            "none";


        teddy.style.display =
            "none";


    }, 1200);


    /*
       Message
    */

    const id =
        Number(
            teddy.dataset.id
        );


    messageTitle.textContent =
        "🧸 TEDDY #" + id;


    message.textContent =
        "Your teddy has arrived! Open your message. 💗";


    /*
       Open popup.
    */

    setTimeout(() => {

        openMessage(
            id
        );

    }, 1250);

}


/* =====================================================
   OPEN MESSAGE
===================================================== */

function openMessage(
    id
) {

    modalImage.src =
        teddyPictures[id];


    modalImage.alt =
        "Memory " + id;


    modalTeddy.textContent =
        "🧸";


    modalTitle.textContent =
        "💗 TEDDY #" + id;


    modalMessage.textContent =
        loveMessages[id];


    messageModal.classList.remove(
        "hidden"
    );


    /*
       Force teddy animation
       to restart every time.
    */

    modalTeddy.style.animation =
        "none";


    void modalTeddy.offsetWidth;


    modalTeddy.style.animation =
        "teddyBounce .7s ease-out";


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
       Special ending.
    */

    if (
        collected >= 10
    ) {

        showFinalMessage();

    }

}


/* =====================================================
   FINAL MESSAGE
===================================================== */

function showFinalMessage() {

    messageTitle.textContent =
        "🎉 ALL 10 TEDDIES!";


    message.textContent =
        "You opened every little message. " +
        "But the biggest prize isn't inside the machine. " +
        "The biggest prize is you. ❤️";


    createManyHearts();

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
                20 +
                Math.random() * 60
            ) + "%";


        heart.style.top =
            (
                45 +
                Math.random() * 25
            ) + "%";


        document.body.appendChild(
            heart
        );


        requestAnimationFrame(() => {

            heart.classList.add(
                "animate"
            );

        });


        setTimeout(() => {

            heart.remove();

        }, 1200);

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
            i * 180
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

            grabTeddy();

        }

    }
);


/* =====================================================
   START WITH BUTTONS DISABLED
===================================================== */

leftButton.disabled =
    true;

rightButton.disabled =
    true;

grabButton.disabled =
    true;