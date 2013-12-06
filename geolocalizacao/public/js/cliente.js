/**
 * Obtém a geolocalização do dispositivo do usuário ou uma determinada cidade fornecida pelo usuário.
 */
var map;

// obtém o nome da cidade armazenada no localstorage. Se o nome fornecido estiver vazio, será exibida a geolocalização do dispositivo.
var cidade = localStorage.getItem('cidade');

// Método que mostra a cidade procurada em um mapa
function obterGeoLocalizacao() {
    // define o tipo de mapa a ser exibido e o zoom.
    var mapOptions = {
        zoom: 17,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    // define o mapa a ser criado na div "map-canvas" da página localizacao.html
    map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
    // responsável pela busca da cidade
    var geocoder = new google.maps.Geocoder();
    // responsável por exibir informações textuais no mapa
    var infowindow = new google.maps.InfoWindow();
    if(navigator.geolocation){
        if(cidade != ''){
            // se o campo cidade definido no localstorage estiver vazio, será exibida a geolocalização do dispositivo do usuário
            geocoder.geocode( { 'address': cidade}, function(results, status) {
                if(status == google.maps.GeocoderStatus.OK) {
                    // mostrao resultado da busca da geolocalização e centraliza-o no mapa
                    map.setCenter(results[0].geometry.location);
                    // define o ícone de localização na região correta do mapa referente a localização do dispositivo
                    var marker = new google.maps.Marker({
                        map: map,
                        position: results[0].geometry.location
                    });
                    // define a informação textual a ser exibida no mapa
                    infowindow.setContent("Você Está Aqui!");
                    infowindow.open(map, marker);
                }else{
                    alert("Erro na geolocalização causado por " + status);
                }
            });
        }else{
            // será exibida a localização da cidade fornecida pelo usuário
            navigator.geolocation.getCurrentPosition(
                function(position){
                    // obtém as coordenadas da cidade fornecida pelo usuário
                    var pos = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
                    // responsável por exibir informações textuais no mapa
                    var infowindow = new google.maps.InfoWindow({
                        map: map,
                        position: pos,
                        content: 'Geolocalização usando HTML5.'
                    });
                    // mostrao resultado da busca da localização da cidade e centraliza-o no mapa
                    map.setCenter(pos);
                     // define o ícone de localização na região correta do mapa referente a localização da cidade
                    var marker = new google.maps.Marker({
                        map: map,
                        position: pos
                    });
                    // define a informação textual a ser exibida no mapa
                    infowindow.setContent("Você Está Aqui!");
                    infowindow.open(map, marker);                
                }, 
                function(){
                    // caso ocorra um erro na localização da cidade, será exibida uma mensagem de erro no mapa
                    handleNoGeolocation(true);
                }
            );
        }
    }else{
        handleNoGeolocation(false);
    }
}

// Método que exibe uma mesnagem de erro de lcoalização de cidade no mapa
function handleNoGeolocation(errorFlag) {
    if(errorFlag) {
        var content = 'Erro no serviço de locilização.';
    }else{
        var content = 'Seu navegador não suporta o serviço de localização.';
    }
    var options = {
        map: map,
        position: new google.maps.LatLng(60, 105),
        content: content
    };
    var infowindow = new google.maps.InfoWindow(options);
    map.setCenter(options.position);
}

// ao clicar no botão voltar, redireciona a aplicação para a página inicial
$("#btn_cancelar").click(function(){
  	location.href = "./index.html";
  	location.refresh();
});

// executa a função obterGeoLocalizacao assim que a página localizacao.html for carregada
google.maps.event.addDomListener(window, 'load', obterGeoLocalizacao);
