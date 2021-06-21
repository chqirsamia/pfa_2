$(document).ready(function(){
$(".minusButton").on("click",function(evt){
evt.preventDefault();
decreaseQuantity($(this));
});
$(".plusButton").on("click",function(evt){
evt.preventDefault();
increaseQuantity($(this));
});

$(".link-remove").on("click",function(evt){
evt.preventDefault();
deletec($(this));
});


updateTotal();

});

function deletec(link){
url=link.attr("href");
$.ajax({
type:"POST",
url:url,
beforeSend:function(xhr){
xhr.setRequestHeader(csrfHeaderName,csrfValue);
}
}).done(function(response){
if (response.includes("supprimé")){
updateTotal();
}
$("#modalBody").modal();
});
}

function decreaseQuantity(link)
{
productId=link.attr("pid");
qtyInput =$("#quantity"+productId);
newQty=parseInt(qtyInput.val())-1;
if(newQty>0) qtyInput.val(newQty);
updateQuantity(productId,newQty);
}
function increaseQuantity(link)
{
productId=link.attr("pid");
qtyInput =$("#quantity"+productId);
newQty=parseInt(qtyInput.val())+1;
if(newQty<10000) qtyInput.val(newQty);
updateQuantity(productId,newQty);}
function updateQuantity(productId,quantity){
url=contextPath+"commandes/updateQuantity/"+productId+'-'+id+'-'+quantity;
$.ajax({
type:"POST",
url:url,
beforeSend:function(xhr){
xhr.setRequestHeader(csrfHeaderName,csrfValue);
}
}).done(function(newSubtotal){
updateSubtotal(newSubtotal,productId);
updateTotal();
});
}
function updateSubtotal(newSubtotal,productId){
$("#subtotal"+productId).text(newSubtotal)

}
function updateTotal(){
total=0.0;

$(".subTotal").each(function(index,element){
total=total+parseFloat(element.innerHTML);
});
$("#totalt").text(total+" MAD");
}