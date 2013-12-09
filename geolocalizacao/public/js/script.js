/**
 * Define as funções dos botões de obter geolocalização e localização de uma determinada cidade.
 */

// função que obtém a localização da cidade fornecida no formulário
$("#btn_obter_cidade").click(function(){
    get_localizacao();
});

// função que obtém a geolocalização do dispositivo do usuário
$("#btn_obter_geolocalizacao").click(function(){
    // define o nome da cidade em branco no localstorage.
	localStorage.setItem('cidade', '');
	// redireciona para a página localizacao.html
  	location.href = "./localizacao.html";
});

// ao pressionar a tecla "enter" é chamada a função que obtém a localização da cidade fornecida no formulário
$(document).keypress(function(evento) {
    // verifica se o evento ocorrido na página é igual ao evento de pressionamento da tecla enter
    if(evento.which == 13) {
        get_localizacao();
    }
});

// função que obtém a localização de uam cidade
function get_localizacao(){
    // cria o campo cidade no localstorage
	cidade = $('#cidade').val();
  	if(cidade != ""){
  	    // define a cidade passada como parâmetro no localstorage    
  		localStorage.setItem('cidade', cidade.toString());
  		// redireciona para a página localizacao.html
    	location.href = "./localizacao.html";
  	}else{
  	    // caso seja fornecido um nome de cidade em branco, dispara um alerta na tela do dispositivo
    	alert("Forneça um nome válido para cidade.");
  	}
};
