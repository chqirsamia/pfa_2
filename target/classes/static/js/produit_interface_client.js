(function($) {
    "use strict"; // Start of use strict
    const url ='http://localhost:8080';




    var urlParm = url + "/findAllProduitNC";
    var ProduitsNonCommandes = httpGet(urlParm);
    rebuildTable(ProduitsNonCommandes);


    function rebuildTable(data) {
        var cards = document.getElementById('cards');
        document.getElementById("cards").innerHTML=" ";

        for (var i = 0; i < data.length; i++) {
            var row = `<div class="card">
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
                            <input id="quantiteC" class="quantiteC" type="text" placeholder="Quantité Commandé">
                            <div>
                              <p id="update"  class="panier-plus" value="`+data[i].id_produit+`" ><i class="fa fa-plus"></i></p>
                            </div>
                          </div>
                    </div>`
            cards.innerHTML += row;


            /* Add apdate event lisner */
            var panierplus = document.getElementsByClassName('panier-plus');
            var numpanierplus = panierplus.length;


            for (var k = 0; k < numpanierplus; k++) {
                //comments[i].addEventListener('click', deleteP, false);

                panierplus[k].addEventListener("click", (function(k){
                    return function() {
                        var id =  document.getElementsByClassName('panier-plus')[k].getAttribute("value");
                        console.log('value = '+ id);
                        var quantiteC = $('#quantiteC').val();
                        var urlP = url + "/addProduitsCommandes/"+id+"/"+quantiteC;
                        console.log("avant pass");
                        var p = httpGet(urlP);
                        console.log("pres pass");
                        var urlProduitNonC = url + "/findAllProduitNC";
                        var ProduitsNonCommandes = httpGet(urlProduitNonC);
                        console.log(" pass");
                        rebuildTable(ProduitsNonCommandes);
                    }
                })(k));

            }
            /**************************/


        }
    }

    function addProduitToPanier(id){
        var urlP = url + "/addProduitsCommandes/"+id;
        httpGet(urlP);
        console.log("pres pass");
        var urlProduitNonC = url + "/findAllProduitNC";
        var ProduitsNonCommandes = httpGet(urlProduitNonC);
        console.log(" pass");
        rebuildTable(ProduitsNonCommandes);

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