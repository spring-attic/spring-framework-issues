// Overall viewmodel for this screen, along with initial state
function ActionViewModel() {
    var self = this;
    
    self.GETActionText = ko.observable("a");
    self.POSTActionText = ko.observable("b");
    self.PUTActionText = ko.observable("c");
    self.DELActionText = ko.observable("d");
    
    // Operations
    self.addAction = function(data) {
        self.actions.push(new Action(data));
    }; 
    
  self.GETAction = function() {
	  var iURL = '/' + location.pathname.split("/")[1] + '/api/use/action/';
	  $.ajax(iURL, {
	    type : "GET",
	    dataType : 'json',
	    beforeSend : function(xhr) {
	      xhr.setRequestHeader("Content-Type", "application/json");
	    },
        success : function(data) {
        	document.getElementById('get').value = JSON.stringify(data);
          },
          error : function(response, status, error) {
        	  document.getElementById('get').value = "GET error";
          },
          complete : function() {
          }
	  });
	};

  self.POSTAction = function() {
	  var iURL = '/' + location.pathname.split("/")[1] + '/api/use/action/';
	  $.ajax(iURL, {
	    type : "POST",
	    data: "00",
	    dataType : 'json',
	    beforeSend : function(xhr) {
	      xhr.setRequestHeader("Content-Type", "application/json");
	    },
        success : function(data) {
        	document.getElementById('post').value = JSON.stringify(data);
          },
          error : function(response, status, error) {
        	  document.getElementById('post').value = "POST error";
          },
          complete : function() {
          }
	  });
	};

  self.PUTAction = function() {
	  var iURL = '/' + location.pathname.split("/")[1] + '/api/use/action/';
	  $.ajax(iURL, {
	    type : "PUT",
	    data: "11",
	    dataType : 'json',
	    beforeSend : function(xhr) {
	      xhr.setRequestHeader("Content-Type", "application/json");
	    },
        success : function(data) {
        	document.getElementById('put').value = JSON.stringify(data);
          },
          error : function(response, status, error) {
        	  document.getElementById('put').value = "PUT error";
          },
          complete : function() {
          }
	  });
	};

  self.DELAction = function() {
	  var iURL = '/' + location.pathname.split("/")[1] + '/api/use/action/1';
	  $.ajax(iURL, {
	    type : "DELETE",
	    data: "22",
	    dataType : 'json',
	    beforeSend : function(xhr) {
	      xhr.setRequestHeader("Content-Type", "application/json");
	    },
        success : function(data) {
        	document.getElementById('del').value = JSON.stringify(data);
          },
          error : function(response, status, error) {
        	  document.getElementById('del').value = "DEL error";
          },
          complete : function() {
          }
	  });
	};
}

ko.applyBindings(new ActionViewModel());