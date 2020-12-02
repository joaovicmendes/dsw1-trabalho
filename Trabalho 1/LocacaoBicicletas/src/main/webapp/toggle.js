function toggleLoader() {
    $(".cliente").toggle();
    $(".locadora").toggle();
    $(".btn").toggleClass("active");
}



/**
 * Change the text of a button
 * @param {el} object HTMLElement: button to change text of
 * @param {dText} string: default text
 * @param {nText} string: new text
 **/
function changeText(el, dText, nText) {
  var content = '',
      context = '';
  
  /**
   * Set the text of a button
   *     - dependant upon current text
   **/
  function setText() {
    return (content === dText) ? nText : dText;
  }
  
  /* Check to see if the browser accepts textContent */
  if ('textContent' in document.body) {
    context = 'textContent';
    /* Get the current button text */
    content = el[context];
  /* Browser does NOT use textContent */
  } else {
    /* Get the button text with fallback option */
    content = el.firstChild.nodeValue;
  }
  
  /* Set button text */
  if (context === 'textContent') {
    el.textContent = setText();
  } else {
    el.firstChild.nodeValue = setText();
  }
}

var defaultText,
    substituteText,
    btn;

/* Default text of the button */
defaultText = 'Cliente';
/* Alternate text for button */
substituteText = 'Locadora';
/* Grab our button */
btn = document.querySelector('.btn');

/* Add a listener to the button instance so we can manipulate it */
window.onload = function () {
  var btn = document.getElementsByClassName("btn")
  btn[0].addEventListener('click', function (e) {
    changeText(this, defaultText, substituteText);
  }, false);
}

