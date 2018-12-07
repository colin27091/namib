<%-- 
    Document   : meteo
    Created on : 6 déc. 2018, 22:48:27
    Author     : valentin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/meteo.css">
        <title>JSP Page</title>
    </head>
    
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"> </script>
    
    <script>
        function meteo() {
				// On fait un appel AJAX pour chercher les états existants
				$.ajax({
					url: "http://api.openweathermap.org/data/2.5/weather",
					dataType: "json",
                                        data:{lat: $("#Latitude").val(), lon: $("#Longitude").val(),appid : "78d05b699827fe4d0c1303d6dded5678" },
					error: showError,
                                        method: "GET",
					success: // La fonction qui traite les résultats
						function(result) {
                                                    $("#main").html("Déscription  : "  + result.weather[0].description);
                                                    
                                                   var  tmp = (result.main.temp - 273.15).toFixed(2);
							$("#temp").html("Température : " + tmp +" °C");
                                                  
                                                    $("#pression").html("Pression : "+ result.main.pressure +" hPa");
                                                    $("#humidité").html("Humidité : "+ result.main.humidity +" %");
                                                    var  ventspeed = (result.wind.speed*3.6).toFixed(2);
                                                    $("#speed").html("Vitesse du vent : "+ ventspeed +" km/h");
                                                    var  ventdeg = (result.wind.deg).toFixed(0);
                                                    $("#deg").html("Degres du vent : " +ventdeg +" degres");
                                                    $("#cloud").html("Nuages : "+ result.clouds.all +" %");
                                                     
                                                       
                                                 
                                                        
						}
				});								
			}
                        function showError(xhr, status, message) {
				$("#erreur").html("Erreur: " + status + " : " + message);
			}
       
        
    </script>
    <body>
        <h1> Données météorologiques </h1>
        
         <form id="codeForm" onsubmit="event.preventDefault(); meteo();">
            <fieldset><legend>Saisir la latitude et  la longitude  </legend>
            Latitude : <input id="Latitude" name="Latitude"> <br/>
            Longitude : <input id="Longitude" name="Longitude"><br/>
            <input type="submit" value="Ajouter">
            </fieldset>
        </form>
        
        <div id="meteo" >
            <p id="main"> </p> <br/>
            <p id="temp"> </p> <br/>
            <p id="pression"> </p> <br/>
            <p id="humidité"> </p> <br/>
            <p id="speed"> </p> <br/>
            <p id="deg"> </p> <br/>
            <p id="cloud"> </p> <br/>
        </div>
        <div id="erreur"> </div>
    </body>
</html>
