(function($) {
    "use strict"; // Start of use strict
    const url ='http://localhost:8080';




    $("#trierPar").change(function(){
        var selectedmethod = $("#trierPar option:selected").text();
        console.log(selectedmethod);
        if(selectedmethod=="prix"){

            var urlParm = url + "/TrierParPrix";
            var produitsParprix = httpGet(urlParm);
            rebuildTable(produitsParprix);

        }

        if(selectedmethod=="quantite"){
            var urlParm = url + "/TrierParQuntite";
            var produitsParQUANTITE = httpGet(urlParm);
            rebuildTable(produitsParQUANTITE);
        }

        if(selectedmethod=="date_cree"){
            var urlParm = url + "/TrierParDate_cree";
            var produitsParDATE = httpGet(urlParm);
            rebuildTable(produitsParDATE);
        }



    });




    /*function rebuildTable(data) {
        var cards = document.getElementById('cards');
        document.getElementById("cards").innerHTML=" ";

        for (var i = 0; i < data.length; i++) {
            var row = `<div class="card">
                            <img src="https://images.ctfassets.net/hrltx12pl8hq/3MbF54EhWUhsXunc5Keueb/60774fbbff86e6bf6776f1e17a8016b4/04-nature_721703848.jpg?fit=fill&w=480&h=270" alt="">
                            <div class="card-header">
                                <h4 class="title" >`+data[i].nom_produit+`</h4>
                                <h4 class="price">`+data[i].prix_unitaire+`</h4>
                            </div>
                            <div class="card-body">
                                <p>`+data[i].description+`</p>
                            </div>
                        </div>`
            cards.innerHTML += row;
            console.log(cards);
        }
    }*/
    function rebuildTable(data) {
        var cards = document.getElementById('cards');
        document.getElementById("cards").innerHTML=" ";

        for (var i = 0; i < data.length; i++) {
            var row = `<div class="card">
<!--                          <img src="data:image/jpeg;base64,"+users[i].image" alt="">-->
                          <img src="data:image/jpeg;base64,`+data[i].image+`" alt="">
                          <div class="card-header">
                            <div class="card-title">
                            <h4 class="title">`+data[i].nom_produit+`</h4>
                            <p id="date_cree">créé le `+data[i].date_cree+`</p>
                              </div>
                            <h4 class="price">`+data[i].prix_unitaire+`</h4>
                          </div>
                          <div class="card-body">
                            <p><strong>`+data[i].titre+`</strong></p><!--mODIF-->
                            <p id="description">`+data[i].description+`</p>
                          </div>
                          <div class="card-footer">
                            <p> Qantité en stock : `+data[i].quantite+`</p>
                            <div>
                              <p id="update" class="update" value="`+data[i].id_produit+`" ><i class="fa fa-pencil-square-o"></i></p>
                              <p id="delete" class="delete" value="`+data[i].id_produit+`"><i class="fa fa-trash"></i></p>
                            </div>
                          </div>
                    </div>`
            cards.innerHTML += row;



            var supp = document.getElementsByClassName('delete');
            var num = supp.length;

            function deleteP() {
                var id =  $('.delete').attr("value");
                console.log('value = '+ id);
                deleteProduct(id);
            }

            for (var j = 0; j < num; j++) {
                //comments[i].addEventListener('click', deleteP, false);

                supp[j].addEventListener("click", (function(j){
                    return function() {
                        var id =  document.getElementsByClassName('delete')[j].getAttribute("value");
                        console.log('value = '+ id);
                        deleteProduct(id);
                    }
                })(j));

            }

            /* Add apdate event lisner */
            var update = document.getElementsByClassName('update');
            var numupdate = update.length;


            for (var k = 0; k < numupdate; k++) {
                //comments[i].addEventListener('click', deleteP, false);

                update[k].addEventListener("click", (function(k){
                    return function() {
                        var id =  document.getElementsByClassName('update')[k].getAttribute("value");
                        console.log('value = '+ id);
                        updateProduct(id);
                    }
                })(k));

            }
            /**************************/


        }
    }
    function updateProduct(id){
        const previewContainer= document.getElementById("imagePreview");
        const previewImage= previewContainer.querySelector(".image-preview__image");

        var urlParm = url + "/findProduitById_produit/"+id;
        var p = httpGet(urlParm);
        var urlCATA = url + "/findCategorieById_Categorie/"+p.id_categorie;
        var d = httpGet(urlCATA);
        var urlEMPLACEMNT = url + "/findEmplacementById_Emplacement/"+p.id_emplacement;
        var e = httpGet(urlEMPLACEMNT);

        $("#form").attr('action',url+'/UpdateProduit');
        document.getElementById("code").readOnly=true;
        $(".creat-team").css('display','flex');

        previewImage.setAttribute("src","data:image/jpeg;base64,"+p.image);
        $("#nom_produit").val(p.nom_produit);
        $("#titre").val(p.titre);
        $("#desc").val(p.description);
        $("#code").val(p.code);
        $("#categorie").val(d.nom_categorie);
        $("#emplacement").val(e.nom_emplacement);

        $("#prix").val(p.prix_unitaire);
        $("#quantite").val(p.quantite);
        $("#etat_stock").val(p.etat_stock);

        /*On peut ajouter date modifier */
        var today = new Date();
        var day =("0"+today.getDate()).slice(-2);
        var month =("0"+(today.getMonth()+1)).slice(-2);
        console.log("'"+today.getFullYear()+"-"+(month)+"-"+(day)+"'");
       // $("#date_cree").val(today.getFullYear()+"-"+(month)+"-"+(day));

    }


    function deleteProduct(id_produit){
        var urlParm = url + "/deleteProduit/"+id_produit;
        httpGet(urlParm);
        var urlfindAll = url + "/findAllProduit";
        var produits = httpGet(urlfindAll);
        rebuildTable(produits);

    }

    function httpGet(theUrl)
    {
        var xmlHttp = new XMLHttpRequest();
        xmlHttp.open( "GET", theUrl, false ); // false for synchronous request
        xmlHttp.send( null );
        var serverResponse = JSON.parse(xmlHttp.responseText);
        return serverResponse;
    }




})(jQuery);