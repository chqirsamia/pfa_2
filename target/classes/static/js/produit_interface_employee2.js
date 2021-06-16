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
                          <img src="https://images.ctfassets.net/hrltx12pl8hq/3MbF54EhWUhsXunc5Keueb/60774fbbff86e6bf6776f1e17a8016b4/04-nature_721703848.jpg?fit=fill&w=480&h=270" alt="">
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
                              <p id="update"><i class="fa fa-pencil-square-o"></i></p>
                              <p id="delete" class="delete" value="`+data[i].id_produit+`"><i class="fa fa-trash"></i></p>
                            </div>
                          </div>
                    </div>`
            cards.innerHTML += row;
            var deletes = document.getElementsByClassName('delete');
            var numdeletes = deletes.length;

            function deleteP() {
                var id =  $('.delete').attr("value");
                console.log('value = '+ id);
                deleteProduct(id);
            }

            for (var j = 0; j < numdeletes; j++) {
                //comments[i].addEventListener('click', deleteP, false);

                deletes[j].addEventListener("click", (function(j){
                    return function() {
                        var id =  document.getElementsByClassName('delete')[j].getAttribute("value");
                        console.log('value = '+ id);
                        deleteProduct(id);
                    }
                })(j));

            }
        }
    }

    function deleteProduct(id_produit) {
        var urlParm = url + "/deleteProduit/" + id_produit;
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