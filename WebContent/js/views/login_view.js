window.LoginView = Backbone.View.extend({

    initialize: function () {    	
        this.render();
    },

    render: function () {
        $(this.el).html(this.template());
        return this;
    },

    events: {
        "click .login" : "login_click"  
    },
    
    login_click: function(event) {
    	event.preventDefault(); 		// Don't let this button submit the form
        $('.alert-error').hide(); 		// Hide any errors on a new submit
        var url = 'j_security_check';
        console.log('Loggin in... ');
        var formValues = {
        	j_username: $('#j_username_id').val(),
        	j_password: $('#j_password_id').val()
        };

        $.ajax({
            url:url,
            type:'POST',
            data: formValues,
            success:function (data) {            	
            	// Verify the error message.
            	var error = $('<div/>').append(data).find('#error').html();
                                
                if (error == "true") {
                }
                else { // If not, send them back to the home page
                	$(".usuario-logado").find("#change_register_id").text(formValues.j_username)+" !";
                	$(".usuario-deslogado").hide();
					$(".usuario-logado").show();
					
					app.navigate("/#ofertas");					
                }
            }
        })
        .done(function () {
            console.log("Login successfully");
        })
        .fail(function () {
            console.log(["Login falhou."]);            
        });
    }
});