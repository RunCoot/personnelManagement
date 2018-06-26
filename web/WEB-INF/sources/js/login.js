window.onload = function () {
    var target_id = $('#id');
    target_id.focus(
        function (ev) {
            $(this).parent().css('border','1px solid #A7A4A4');
        }
    );
    target_id.blur(
        function (ev) {
            $(this).parent().css('border','1px solid #DADADA');
        }
    );
    var target_world = $('#password');
    target_world.focus(
        function (ev) {
            $(this).parent().css('border','1px solid #A7A4A4');
        }
    );
    target_world.blur(
        function (ev) {
            $(this).parent().css('border','1px solid #DADADA');
        }
    )
};