(function($) {
    "use strict"; // Start of use strict



    // Popup Singin
    $(".btn-grp").click(function(e) {
        e.preventDefault();
        $(".creat-team").css('display','flex');
    });
    $(".cloose").click(function(e) {
        e.preventDefault();
        $(".creat-team").css('display','none');
    });





    const inpFile=document.getElementById("inpFile");
    const previewContainer= document.getElementById("imagePreview");
    const previewImage= previewContainer.querySelector(".image-preview__image");
// const previewDefaultText=previewContainer.querySelector(".image-preview__default-text");

    inpFile.addEventListener("change",function () {
        const file = this.files[0];
        const reader=new FileReader();
        if(file){

            // previewDefaultText.style.display="none";
            previewImage.style.display="block";
            reader.addEventListener("load",function () {

                previewImage.setAttribute("src",this.result);
            });
            /* reader.addEventListener("unload",function(){
                 previewImage.setAttribute("src","images/innconue.png");
             });*/
            reader.readAsDataURL(file);
        }else{
            // previewDefaultText.style.display=null;
            previewImage.style.display=null;
            previewImage.setAttribute("src","images/innconue.png");
        }
    });
    /*const container = document.querySelector(".container");
    const suivant = document.querySelector(".cle");
    const p_suivant= document.querySelector(".page-wrapper");
    const a_suivant=document.querySelector(".avatar-upload");

    document.getElementById("ele2").style.display="none";
    document.getElementById("butt").addEventListener("click",()=>{
        document.getElementById("ele1").style.display="none";
        document.getElementById("ele2").style.display="block";

    });*/





})(jQuery);
