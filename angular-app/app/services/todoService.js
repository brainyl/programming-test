(function() {
  'use strict';

  angular.module('todoService', ['pouchdb'])
  .factory('Todos', function(pouchDB) {
    var _db = new pouchDB('programming_test');  
    var Todos = {};
    Todos.get = function() {
      return _db.allDocs({
                  include_docs: true,
              }).then(function(response){
                var result = response.rows.map(function(obj){
                  var rObj = {};
                  rObj.id = obj.doc._id;
                  rObj.rev = obj.doc._rev;
                  rObj.text = obj.doc.text;
                  return rObj
                });
                return result;
              });
    };

    Todos.create = function(formData) {
      return _db.post({text: formData.text}).then(function(response){
        response.text = formData.text;
        return response;
      });
    };
    Todos.update = function(formData) {
      return _db.put({_id: formData.id, _rev: formData.rev, text: formData.text}).then(function(response){
        response.text = formData.text;
        return response;
      });
    };

    Todos.delete = function(id) {
      return _db.get(id).then(function(doc){
        return _db.remove(doc);
      });
    };

    return Todos;
  });
})();