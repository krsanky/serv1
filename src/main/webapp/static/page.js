/* page.js */
Mousetrap.bind('ctrl+alt+k', function(e) {
    alert("control alt k");
    return false;
});
/*
For modifier keys you can use shift, ctrl, alt, or meta.

Other special keys are: backspace, tab, enter, return, capslock,
esc, escape, space, pageup, pagedown, end, home, left, up, right,
down, ins, del, and plus.

Any other key you should be able to reference by name like a, /, $, *, or =.
*/
// konami code!
Mousetrap.bind('up up down down left right left right b a enter', function() {
    highlight([21, 22, 23]);
});

