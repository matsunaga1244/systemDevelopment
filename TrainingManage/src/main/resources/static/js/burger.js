// ハンバーガーボタン
let hamburgerBtn = document.getElementById('header-hamburger');
// ハンバーガーウィンドウ
let hamburgerWindw = document.getElementById('hamburger-window');

/**
 * ハンバーガーメニューの開閉を制御
 */
hamburgerBtn.addEventListener('click', () => {
  // ハンバーガーメニューのopenとcloseの状態を制御
  if (hamburgerBtn.classList.contains('active')) {
    hamburgerBtn.classList.remove('active');
  } else {
    hamburgerBtn.classList.add('active');
  }
  // ハンバーガーウィンドウの表示状態を制御
  if (hamburgerWindw.classList.contains('open')) {
    hamburgerWindw.classList.remove('open');
  } else {
    hamburgerWindw.classList.add('open');
  }
});

// button要素がクリックされたらアコーディオンを開閉する
const menuBtns = document.querySelectorAll('.acordion-btn');
const menuLists = document.querySelectorAll('.acordion');

menuBtns.forEach((element, index) => {
  element.addEventListener('click', function () {
    menuBtns[index].classList.toggle('is-open');
    menuLists[index].classList.toggle('is-open');
  });
});