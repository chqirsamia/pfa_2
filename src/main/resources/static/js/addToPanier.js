$(document).ready(function(){
$("#confirmer").on("click",function(e){
addToPanier();

});

function addToPanier(){
quantity=$("#quantity"+productId).val();
url=contextPath+commandes/addMyProduit/+productId+'-'+id+'-'+quantity;
$.ajax({
type:"POST",
url:url,
beforeSend:function(xhr){
xhr.setRequestHeader(csrfHeaderName,csrfValue);
}
})
}});