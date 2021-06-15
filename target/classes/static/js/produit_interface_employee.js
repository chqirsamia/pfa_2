(function($) {
    "use strict"; // Start of use strict
    const url ='http://localhost:8080';



    // Popup Singin
    $(".btn-grp").click(function(e) {
        e.preventDefault();
        $(".grp").css('display','none');
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

    function rebuildTable(data) {
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