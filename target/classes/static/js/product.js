(function($) {
    "use strict"; // Start of use strict
    const url ='http://localhost:8080/commandes';



    // Popup Singin
    $(".btn-grp").click(function(e) {
        e.preventDefault();
        $(".grp").css('display','none');
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


            /*chercherPar.add("Categorie");
            chercherPar.add("Emplacement");
            chercherPar.add("Employee");
            chercherPar.add("Année de creation");
            chercherPar.add("mois de creation");*/

            if (nom_produit.includes(value) || titre.includes(value) || description.includes(value)) {
                filtredData.push(data[i]);
                console.log(data[i]);
            }

        }
        return filtredData;
    }

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

   /* function rebuildTable(data) {
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
                              
                              <p id="add" class="add" value="`+data[i].id_produit+`"><i class="fa fa-plus"></i></p>
                            </div>
                          </div>
                    </div>`
            var adds = document.getElementsByClassName('add');
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
                                    <p id="add" class="add" value="`+data[i].id_produit+`"><i class="fa fa-plus"></i></p>
                               </div>
                          </div>
                    </div>`
            cards.innerHTML += row;
              var add = document.getElementsByClassName('add');
         var num = add.length;
    function addP() {
                var id =  $('.add').attr("value");
                console.log('value = '+ id);
               addProduct(id);
            }
for (var j = 0; j < num; j++) {
                //comments[i].addEventListener('click', addP, false);

                add[j].addEventListener("click", (function(j){
                    return function() {
                        var id =  document.getElementsByClassName('add')[j].getAttribute("value");
                        console.log('value = '+ id);
                        addProduct(id);
                    }
                })(j));

            }


      }
    }
      
   
    function addProduct(id_produit){
        var urlParm = url + "/addPoduit/"+id_produit+'-'+id;
        httpGet(urlParm);
        alert('add');
        var urlfindAll = url + "/findAllProduit";
        var produits = httpGet(urlfindAll);
     
        /*
        $.ajax({
            url: 'http://localhost:8080/deleteProduit/'+id_produit,
            method: 'GET',
            success: function () {
                var urlParm = url + "/findAllProduit";
                var produits = httpGet(urlParm);
                rebuildTable(produits);
            },
            error: function (error) {
                alert(error);
            }
        })*/

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




