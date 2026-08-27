/* ============ PIXEL PLUSHIE SPRITES ============ */
/* 16 x 20 pixel grid. Each plushie shares the same chibi silhouette
   (SIL) but gets its own colors, ear shape, and a small "extra" detail
   so every prize actually looks like its own toy instead of a flat emoji. */

const SIL = [
    null, null, null, null,      // 0-3  (reserved for ears / horn)
    [6, 9],                      // 4  head top
    [5, 10],                     // 5
    [4, 11],                     // 6
    [4, 11],                     // 7
    [4, 11],                     // 8
    [4, 11],                     // 9
    [5, 10],                     // 10 neck
    [3, 12],                     // 11 shoulders
    [2, 13],                     // 12
    [2, 13],                     // 13
    [1, 14],                     // 14 body
    [1, 14],                     // 15
    [1, 14],                     // 16
    [1, 14],                     // 17
    [2, 13],                     // 18
    [3, 12],                     // 19 base
];

function px(ctx, x, y, color, w = 1, h = 1) {
    ctx.fillStyle = color;
    ctx.fillRect(x, y, w, h);
}

function drawEars(ctx, type, color) {
    if (!type || type === 'none') return;
    if (type === 'round') {
        px(ctx, 4, 3, color, 2, 2);
        px(ctx, 10, 3, color, 2, 2);
    } else if (type === 'big') {
        px(ctx, 3, 2, color, 3, 3);
        px(ctx, 10, 2, color, 3, 3);
    } else if (type === 'long') {
        px(ctx, 6, 0, color, 2, 4);
        px(ctx, 8, 0, color, 2, 4);
    } else if (type === 'floppy') {
        px(ctx, 3, 6, color, 2, 3);
        px(ctx, 11, 6, color, 2, 3);
    } else if (type === 'triangle') {
        const left = [[4,2],[5,2],[4,3],[5,3],[3,4],[4,4]];
        left.forEach(([x, y]) => px(ctx, x, y, color));
        left.forEach(([x, y]) => px(ctx, 15 - x, y, color));
    }
}

function drawFace(ctx, cfg) {
    if (cfg.eyeStyle === 'bulge') {
        px(ctx, 5, 2, '#ffffff', 2, 2);
        px(ctx, 9, 2, '#ffffff', 2, 2);
        px(ctx, 6, 3, '#1a1a1a');
        px(ctx, 9, 3, '#1a1a1a');
    } else {
        px(ctx, 6, 8, '#1a1a1a');
        px(ctx, 9, 8, '#1a1a1a');
    }
    if (cfg.snout) {
        px(ctx, 7, 9, cfg.snout, 2, 1);
    }
    if (cfg.blush !== false) {
        ctx.globalAlpha = 0.55;
        px(ctx, 4, 9, '#ff9ab8');
        px(ctx, 11, 9, '#ff9ab8');
        ctx.globalAlpha = 1;
    }
}

function drawPlushie(ctx, cfg) {
    ctx.clearRect(0, 0, 16, 20);
    SIL.forEach((range, y) => {
        if (range) px(ctx, range[0], y, cfg.body, range[1] - range[0] + 1, 1);
    });
    drawEars(ctx, cfg.earType, cfg.earColor || cfg.body);
    drawFace(ctx, cfg);
    if (cfg.extra) cfg.extra(ctx);
}

function makeSpriteCanvas(cfg) {
    const canvas = document.createElement('canvas');
    canvas.width = 16;
    canvas.height = 20;
    const ctx = canvas.getContext('2d');
    ctx.imageSmoothingEnabled = false;
    drawPlushie(ctx, cfg);
    return canvas;
}

/* ============ THE 10 PRIZES ============ */
const PLUSHIES = [
    { name: 'Bear',    pos: 5,  body: '#8a5a3c', earColor: '#6e4530', earType: 'round',
        snout: '#d9b38c' },
    { name: 'Bunny',   pos: 15, body: '#f5eee6', earColor: '#f3b6cf', earType: 'long',
        snout: '#f3b6cf' },
    { name: 'Cat',     pos: 25, body: '#e0a94a', earColor: '#c98d31', earType: 'triangle',
        snout: '#c98d31',
        extra: (ctx) => { px(ctx, 1, 9, '#3a2a1a'); px(ctx, 14, 9, '#3a2a1a'); } },
    { name: 'Puppy',   pos: 35, body: '#c99a6b', earColor: '#8a5f38', earType: 'floppy',
        snout: '#5a3d24',
        extra: (ctx) => { px(ctx, 5, 13, '#8a5f38'); px(ctx, 10, 15, '#8a5f38', 2, 1); } },
    { name: 'Fox',     pos: 45, body: '#ea7a30', earColor: '#ea7a30', earType: 'triangle',
        snout: '#ffffff',
        extra: (ctx) => { px(ctx, 4, 2, '#1a1a1a'); px(ctx, 11, 2, '#1a1a1a');
            px(ctx, 6, 13, '#ffffff', 4, 2); } },
    { name: 'Panda',   pos: 55, body: '#ffffff', earColor: '#1a1a1a', earType: 'round',
        snout: '#1a1a1a', blush: false,
        extra: (ctx) => { px(ctx, 5, 7, '#1a1a1a', 2, 2); px(ctx, 9, 7, '#1a1a1a', 2, 2); } },
    { name: 'Koala',   pos: 65, body: '#a9b0b6', earColor: '#c7ccd1', earType: 'big',
        snout: '#5b6672' },
    { name: 'Unicorn', pos: 75, body: '#f7d7ea', earColor: '#f0aed0', earType: 'round',
        snout: '#f0aed0',
        extra: (ctx) => {
            px(ctx, 7, 1, '#ffd873', 1, 2); px(ctx, 8, 0, '#ffd873', 1, 2);
            const colors = ['#ff5f5f', '#ffbb4c', '#ffe14d', '#8ee08a', '#4cc9f5'];
            colors.forEach((c, i) => px(ctx, 3, 6 + i, c));
        } },
    { name: 'Piggy',   pos: 85, body: '#f6b8c6', earColor: '#e893a9', earType: 'round',
        snout: '#e893a9',
        extra: (ctx) => { px(ctx, 7, 9, '#c9647f'); px(ctx, 8, 9, '#c9647f'); } },
    { name: 'Froggy',  pos: 95, body: '#8fd694', earColor: null, earType: 'none',
        eyeStyle: 'bulge', blush: false,
        extra: (ctx) => { px(ctx, 6, 11, '#4f9f57', 4, 1); } },
];

/* ============ GAME LOGIC ============ */
let clawPos = 50;
let collected = 0;
let busy = false;
const CATCH_RADIUS = 5;

const startScreen = document.getElementById('start-screen');
const gameScreen = document.getElementById('game-screen');
const letterScreen = document.getElementById('letter-screen');
const winOverlay = document.getElementById('winOverlay');

const claw = document.getElementById('claw');
const clawString = document.getElementById('clawString');
const clawCargo = document.getElementById('clawCargo');
const plushieLayer = document.getElementById('plushieLayer');
const scoreEl = document.getElementById('score');
const tray = document.getElementById('tray');
const toast = document.getElementById('toast');

function pad(n) { return n < 10 ? '0' + n : '' + n; }

function showScreen(el) {
    [startScreen, gameScreen, letterScreen].forEach((s) => s.classList.remove('active'));
    el.classList.add('active');
}

function buildTray() {
    tray.innerHTML = '';
    PLUSHIES.forEach((p, i) => {
        const slot = document.createElement('div');
        slot.className = 'tray-slot';
        slot.id = 'slot-' + i;
        tray.appendChild(slot);
    });
}

function buildPlushies() {
    plushieLayer.innerHTML = '';
    PLUSHIES.forEach((p, i) => {
        const el = document.createElement('div');
        el.className = 'plushie';
        el.id = 'plushie-' + i;
        el.style.left = p.pos + '%';
        el.dataset.caught = 'false';
        el.appendChild(makeSpriteCanvas(p));
        plushieLayer.appendChild(el);
    });
}

function resetGame() {
    collected = 0;
    scoreEl.textContent = pad(0);
    clawPos = 50;
    claw.style.left = clawPos + '%';
    clawString.style.height = '0px';
    clawCargo.classList.remove('show');
    clawCargo.innerHTML = '';
    buildTray();
    buildPlushies();
    winOverlay.classList.remove('active');
}

function moveClaw(delta) {
    if (busy) return;
    clawPos = Math.min(95, Math.max(5, clawPos + delta));
    claw.style.left = clawPos + '%';
}

function showToast(msg) {
    toast.textContent = msg;
    toast.classList.add('show');
    setTimeout(() => toast.classList.remove('show'), 900);
}

function dropClaw() {
    if (busy || collected >= 10) return;
    busy = true;
    clawString.style.height = '150px';

    setTimeout(() => {
        let target = null;
        let bestDist = CATCH_RADIUS + 1;
        PLUSHIES.forEach((p, i) => {
            const el = document.getElementById('plushie-' + i);
            if (el.dataset.caught === 'false') {
                const dist = Math.abs(p.pos - clawPos);
                if (dist < bestDist) {
                    bestDist = dist;
                    target = i;
                }
            }
        });

        if (target !== null) {
            const el = document.getElementById('plushie-' + target);
            el.dataset.caught = 'true';
            el.classList.add('gone');
            clawCargo.innerHTML = '';
            clawCargo.appendChild(makeSpriteCanvas(PLUSHIES[target]));
            clawCargo.classList.add('show');
            showToast('GOTCHA!');

            setTimeout(() => {
                clawString.style.height = '0px';
                setTimeout(() => {
                    const slot = document.getElementById('slot-' + target);
                    slot.innerHTML = '';
                    slot.appendChild(makeSpriteCanvas(PLUSHIES[target]));
                    slot.classList.add('filled');
                    clawCargo.classList.remove('show');
                    clawCargo.innerHTML = '';
                    collected++;
                    scoreEl.textContent = pad(collected);
                    busy = false;

                    if (collected >= 10) {
                        setTimeout(() => winOverlay.classList.add('active'), 500);
                    }
                }, 500);
            }, 350);
        } else {
            showToast('MISSED!');
            setTimeout(() => {
                clawString.style.height = '0px';
                setTimeout(() => { busy = false; }, 500);
            }, 250);
        }
    }, 500);
}

function startGame() {
    resetGame();
    showScreen(gameScreen);
}

startScreen.addEventListener('click', startGame);

document.addEventListener('keydown', (e) => {
    if (startScreen.classList.contains('active') && (e.code === 'Enter' || e.code === 'Space')) {
        e.preventDefault();
        startGame();
    }
    if (!gameScreen.classList.contains('active')) return;
    if (e.code === 'ArrowLeft') moveClaw(-6);
    if (e.code === 'ArrowRight') moveClaw(6);
    if (e.code === 'Space' || e.code === 'Enter') { e.preventDefault(); dropClaw(); }
});

document.getElementById('leftBtn').addEventListener('click', (e) => { e.stopPropagation(); moveClaw(-6); });
document.getElementById('rightBtn').addEventListener('click', (e) => { e.stopPropagation(); moveClaw(6); });
document.getElementById('dropBtn').addEventListener('click', (e) => { e.stopPropagation(); dropClaw(); });

document.getElementById('toLetterBtn').addEventListener('click', () => {
    winOverlay.classList.remove('active');
    showScreen(letterScreen);
});

const envelope = document.getElementById('envelope');
const letterCard = document.getElementById('letterCard');
envelope.addEventListener('click', () => {
    envelope.classList.add('open');
    setTimeout(() => letterCard.classList.add('show'), 350);
});

document.getElementById('replayBtn').addEventListener('click', () => {
    envelope.classList.remove('open');
    letterCard.classList.remove('show');
    resetGame();
    showScreen(gameScreen);
});