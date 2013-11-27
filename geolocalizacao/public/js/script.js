$("#btn_obter_cidade").click(function(){
	cidade = $('#cidade').val();
  	if(cidade != ""){
  		localStorage.setItem('cidade', cidade.toString());
    	location.href = "./localizacao.html";
  	}else{
    	alert("Forneça um nome válido para cidade.");
  	}
});

$("#btn_obter_geolocalizacao").click(function(){
	localStorage.setItem('cidade', '');
  	location.href = "./localizacao.html";
});