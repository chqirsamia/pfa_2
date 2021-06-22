(function($) {
    "use strict"; // Start of use strict
    const url ='http://localhost:8080';




    $(".card__exit").click(function(e) {
        e.preventDefault();
        $(".creat-team").css('display', 'none');
    });



    $("#chercherPar").change(function(){
        var selectedmethod = $("#chercherPar option:selected").text();
        console.log(selectedmethod);
        if(selectedmethod=="Categorie"){

            $('#txtSearch').on('keyup', function () {
                var value = $(this).val();
                var urlParm = url + "/findProduitsByCategorie/"+value;
                var produitsParCATA = httpGet(urlParm);
                rebuildTable(produitsParCATA);

            });
        }

        if(selectedmethod=="Emplacement"){

            $('#txtSearch').on('keyup', function () {
                var value = $(this).val();
                var urlParm = url + "/findProduitByEmplacement/"+value;
                var produitsParEMPACEMENT = httpGet(urlParm);
                rebuildTable(produitsParEMPACEMENT);

            });
        }

        if(selectedmethod=="Employee"){

            $('#txtSearch').on('keyup', function () {
                var value = $(this).val();
                var urlParm = url + "/findProduitByEmployee/"+value;
                var produitsParEMPLOYEE = httpGet(urlParm);
                rebuildTable(produitsParEMPLOYEE);

            });
        }

        if(selectedmethod=="Année de creation"){

            $('#txtSearch').on('keyup', function () {
                var value = $(this).val();
                var urlParm = url + "/findProduitByAnnee_cree/"+value;
                var produitsParAnnee = httpGet(urlParm);
                rebuildTable(produitsParAnnee);

            });
        }

        if(selectedmethod=="mois de creation"){

            $('#txtSearch').on('keyup', function () {
                var value = $(this).val();
                var urlParm = url + "/findProduitByMois_cree/"+value;
                var produitsParMois = httpGet(urlParm);
                rebuildTable(produitsParMois);

            });
        }

        if(selectedmethod=="All"){

            var urlParm = url + "/findAllProduit";
            var produits = httpGet(urlParm);
            console.log(produits);
            rebuildTable(produits);
            //var produits ;

            $('#txtSearch').on('keyup', function () {
                var value = $(this).val();
                console.log('value = '+ value);
                //Get Filtered Product list
                if(value != null) {
                    var data = FiltredFunction(value, produits);
                    rebuildTable(data);
                }
                //clear the table and rebuild using new filtred data
                else {
                    rebuildTable(produits);
                }

            });



        }



    });

    var urlParm = url + "/findAllProduit";
    var produits = httpGet(urlParm);
    console.log(produits);
    rebuildTable(produits);
    //var produits ;

    $('#txtSearch').on('keyup', function () {
        var value = $(this).val();
        console.log('value = '+ value);
        //Get Filtered Product list
        if(value != null) {
            var data = FiltredFunction(value, produits);
            rebuildTable(data);
        }
        //clear the table and rebuild using new filtred data
        else {
            rebuildTable(produits);
        }

    });

    function FiltredFunction(value, data) {
        var filtredData = [] ;

        for (var i = 0; i < data.length; i++) {

            value = value.toLowerCase();
            var nom_produit = data[i].nom_produit.toLowerCase();
            var titre = data[i].titre.toLowerCase();
            var description = data[i].description.toLowerCase();
            if (nom_produit.includes(value) || titre.includes(value) || description.includes(value)) {
                filtredData.push(data[i]);
                console.log(data[i]);
            }

        }
        return filtredData;
    }



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
                              <p id="update" class="voir-plus" value="`+data[i].id_produit+`" ><i class="fa fa-arrow-right"></i></p>
                            </div>
                          </div>
                    </div>`
            cards.innerHTML += row;


            /* Add voir plus event lisner */
            var voir_plus = document.getElementsByClassName('voir-plus');
            var numvoirplus = voir_plus.length;


            for (var k = 0; k < numvoirplus; k++) {
                voir_plus[k].addEventListener("click", (function(k){
                    return function() {
                        var id =  document.getElementsByClassName('voir-plus')[k].getAttribute("value");
                        console.log('value = '+ id);
                        voirProduct(id);
                    }
                })(k));

            }
            /**************************/


        }
    }
    function voirProduct(id){

        var urlParm = url + "/findProduitById_produit/"+id;
        var p = httpGet(urlParm);
        var urlCATA = url + "/findCategorieById_Categorie/"+p.id_categorie;
        var d = httpGet(urlCATA);
        var urlEMPLACEMNT = url + "/findEmplacementById_Emplacement/"+p.id_emplacement;
        var e = httpGet(urlEMPLACEMNT);


        $(".creat-team").css('display','flex');

       // $("#nom_produit").html("Hello <b>world!</b>");
        $("#nom_produit").html(p.nom_produit);
        $("#titre").html(p.titre);
        $("#date_cree").html("créé le : "+p.date_cree);
        console.log(p.date_cree);
        $("#date_modifie").html("modifié le : "+p.date_modifier);

        $("#desc").html(p.description);
        $("#code").html(p.code);
        $("#categorie").html("Categorie : "+d.nom_categorie);
        $("#emplacement").html("Emplacement : "+e.nom_emplacement);
        /*$("#emplacement option:selected").val(d.nom_employee);*/

        $("#prix").html(p.prix_unitaire);
        $("#quantite").html("Qantité en stock : "+p.quantite);
        $("#etat_stock").html(p.etat_stock);
        $("#download").attr('href',url+'/export/produit/'+p.id_produit);


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