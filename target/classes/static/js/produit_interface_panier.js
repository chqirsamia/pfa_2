(function($) {
    "use strict"; // Start of use strict
    const url ='http://localhost:8080';

    var urlProduitC = url + "/findAllProduitC/16";
    var ProduitsCommandes = httpGet(urlProduitC);
    rebuildTable(ProduitsCommandes);

    $(".confirme").click(function(e) {
        e.preventDefault();
        var urlcon = url + "/addCommand/16";
        var con = httpGet(urlcon);
        rebuildTable(ProduitsCommandes);
    });


    $(".annule").click(function(e) {
        e.preventDefault();
        var urlannul = url + "/deleteAllProduitsCommandes/16";
        var annul = httpGet(urlannul);
        rebuildTable(ProduitsCommandes);
    });




    function CalculeTotaleCommande(){
        var urlProduitC = url + "/findAllProduitC/16";
        var ProduitsCommandes = httpGet(urlProduitC);
        var totale =0;
        for(var t=0;t<ProduitsCommandes.length;t++){
            var pc = ProduitsCommandes[t];
            totale+= pc.quantiteC * pc.prix_unitaire;
        }
        $('.header').html('<button>Totale : '+totale+'<i class="fa fa-paper-plane"></i></button>');

    }

    function rebuildTable(data) {
        var cards = document.getElementById('cards');
        document.getElementById("cards").innerHTML=" ";

        for (var i = 0; i < data.length; i++) {
            var row = `<div class="card">
                          <img src="data:image/jpeg;base64,`+data[i].image+`" alt="">
                          <div class="card-header">
                            <div class="card-title">
                            <h4 class="title">`+data[i].nom_produit+`</h4>
                              </div>
                            <h4 class="price">`+data[i].prix_unitaire+`</h4>
                          </div>
                          <div class="card-body">
                            <p><strong>`+data[i].titre+`</strong></p><!--mODIF-->
                            <p id="description">`+data[i].description+`</p>
                          </div>
                          <div class="card-footer">
                            <p> Qantité Commandée : `+data[i].quantiteC+`</p>
                            <div>
                              <p id="delete" class="delete" value="`+data[i].id_produitC+`"><i class="fa fa-times"></i></p>
                            </div>
                          </div>
                    </div>`
            cards.innerHTML += row;

            CalculeTotaleCommande();
            /* Add apdate event lisner */
            var deletep = document.getElementsByClassName('delete');
            var numdelete = deletep.length;


            for (var k = 0; k < numdelete; k++) {

                deletep[k].addEventListener("click", (function(k){
                    return function() {
                        var pid =  document.getElementsByClassName('delete')[k].getAttribute("value");
                        console.log('value = '+ pid);
                        var urlD = url + "/deleteProduitsCommandes/"+pid+"/16";
                        console.log("avant pass");
                        var d = httpGet(urlD);
                        console.log("pres pass");
                        var urlProduitC = url + "/findAllProduitC/16";
                        var ProduitsCommandes = httpGet(urlProduitC);
                        console.log(" pass");
                        rebuildTable(ProduitsCommandes);
                    }
                })(k));

            }
            /**************************/


        }
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