$(document).ready(function(){

	$("#signout").click(function(e){
		e.preventDefault();
		$("#signout-form").submit();
	});
	$("#pass2").keyup(checkPasswordMatch);
	$("#signUpButton").click(function(e){
		var pass1 = $("#pass").val();
        var pass2 = $("#pass2").val();

        if  (pass1 != pass2) {
        	e.preventDefault();
        	$("#divPasswordsMatch").html("Please enter matching passwords!");
         	$("#divPasswordsMatch").attr("class","registrationFormAlert red");
        }
	});
});


function checkPasswordMatch() {
    var pass1 = $("#pass").val();
    var pass2 = $("#pass2").val();

    if (pass1 != pass2) {
        $("#divPasswordsMatch").html("Passwords do not match!");
    	$("#divPasswordsMatch").attr("class","registrationFormAlert red");
    }
    else {
        $("#divPasswordsMatch").html("Passwords match.");
        $("#divPasswordsMatch").attr("class","registrationFormAlert green");
    }
    
        
}