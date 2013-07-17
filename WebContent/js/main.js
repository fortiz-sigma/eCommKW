var AppRouter = Backbone.Router.extend({

    routes: {
        ""                  	: "list",
        "ofertas"				: "list",
        "products/page/:page"	: "list",
        "products/new"         	: "addProduct",
        "rest/products/:id"    	: "productDetails",
        "about"             	: "about", 
        "login" 				: "login"  
    },

    initialize: function () {
        this.headerView = new HeaderView();
        $('.header').html(this.headerView.el);
        
        this.categoryView = new CategoryView();
        $('.category').html(this.categoryView.el);        
    },
    
    login: function() {
        if (!this.loginView) {
        	this.loginView = new LoginView();
        }
        $('#content').html(this.loginView.el);
    },   

	list: function(page) {
        var p = page ? parseInt(page, 10) : 1;
        var productList = new ProductCollection();
        productList.fetch({success: function(){
            $("#content").html(new ProductListView({model: productList, page: p}).el);
        }});
        this.headerView.selectMenuItem('home-menu');
    },

    productDetails: function (id) {
        var product = new Product({id: id});
        product.fetch({success: function(){
            $("#content").html(new ProductView({model: product}).el);
        }});
        this.headerView.selectMenuItem();
    },

	addProduct: function() {
        var product = new Product();
        $('#content').html(new ProductView({model: product}).el);
        this.headerView.selectMenuItem('add-menu');
	},

    about: function () {
        if (!this.aboutView) {
            this.aboutView = new AboutView();
        }
        $('#content').html(this.aboutView.el);
        this.headerView.selectMenuItem('about-menu');
    }

});

utils.loadTemplate(['HeaderView', 'ProductView', 'ProductListItemView', 'AboutView', 'LoginView', 'CategoryView'], function() {
    app = new AppRouter();
    Backbone.history.start();
});
