var map;
var cidade = localStorage.getItem('cidade');

function obterGeoLocalizacao() {
    var mapOptions = {
        zoom: 17,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);
    var geocoder = new google.maps.Geocoder();
    var infowindow = new google.maps.InfoWindow();
    if(navigator.geolocation){
        if(cidade != ''){
            geocoder.geocode( { 'address': cidade}, function(results, status) {
                if(status == google.maps.GeocoderStatus.OK) {
                    map.setCenter(results[0].geometry.location);
                    var marker = new google.maps.Marker({
                        map: map,
                        position: results[0].geometry.location
                    });
                    infowindow.setContent("Você Está Aqui!");
                    infowindow.open(map, marker);
                }else{
                    alert("Erro na geolocalização causado por " + status);
                }
            });
        }else{
            navigator.geolocation.getCurrentPosition(
                function(position){
                    var pos = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
                    var infowindow = new google.maps.InfoWindow({
                        map: map,
                        position: pos,
                        content: 'Geolocalização usando HTML5.'
                    });
                    map.setCenter(pos);
                    var marker = new google.maps.Marker({
                        map: map,
                        position: pos
                    });
                    infowindow.setContent("Você Está Aqui!");
                    infowindow.open(map, marker);                
                }, 
                function(){
                    handleNoGeolocation(true);
                }
            );
        }
    }else{
        handleNoGeolocation(false);
    }
}

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

$("#btn_cancelar").click(function(){
  	location.href = "./index.html";
  	location.refresh();
});


google.maps.event.addDomListener(window, 'load', obterGeoLocalizacao);
