'use strict'
const span = document.getElementsByClassName('btn-show')[0];
const input = document.getElementsByClassName('input-password')[0];

span.addEventListener('click', (event) => {
    event.preventDefault();
   input.type === "password" ? input.type = 'text' : input.type = 'password';
});
