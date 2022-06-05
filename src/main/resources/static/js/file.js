$(document).ready(function () {

    $("#fileImage").change(function () {

        if (this.files[0].size > 102400) {
            this.setCustomValidity("Obrazek musi zajmować mniej niż 100KB!");
            this.reportValidity();
        } else {
            this.setCustomValidity("");
            showImageThumbnail(this);
        }


    });

    function showImageThumbnail(fileInput) {
        var file = fileInput.files[0];
        var reader = new FileReader();
        reader.onload = function (e) {
            $("#thumbnail").attr("src", e.target.result);
        };
        reader.readAsDataURL(file);
    }
});