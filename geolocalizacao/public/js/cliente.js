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
        if (status == google.maps.GeocoderStatus.OK) {
          map.setCenter(results[0].geometry.location);
          var marker = new google.maps.Marker({
            map: map,
            position: results[0].geometry.location
          });
          infowindow.setContent("Você Está Aqui!");
          infowindow.open(map, marker);      
        }else{
          alert("Geocode was not successful for the following reason: " + status);
        }
      });   
    }else{
      navigator.geolocation.getCurrentPosition(
          function(position){
            var pos = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);      
            var marker = new google.maps.Marker({
              position: pos,
              map: map,
              draggable:true,
              animation: google.maps.Animation.DROP,
              title: 'Você está aqui!'});
              if(status == google.maps.GeocoderStatus.OK){
                map.setCenter(results[0].geometry.location);
                var marker = new google.maps.Marker({
                  map: map,
                  position: results[0].geometry.location
                });
              }else{
                alert("Geocode was not successful for the following reason: " + status);
              }     
            map.setCenter(pos);
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
  if (errorFlag) {
    var content = 'Erro no serviço de locilização.';
  } else {
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

google.maps.event.addDomListener(window, 'load', obterGeoLocalizacao);