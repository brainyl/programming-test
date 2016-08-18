describe('Programming Test', function() {
  var Todos;
  beforeEach(inject(function() {
    var $injector = angular.injector(['ng', 'todoService']);
    Todos = $injector.get('Todos');
  }));
   afterEach(function(done) {
    function tearDown($window) {
      var rawDb = new $window.PouchDB('programming_test');
      rawDb.destroy(function(err, info) {
        if (err) {
          throw err;
        }
        expect(info.ok).toBe(true);
        done();
      });
    }
    inject(tearDown);
  });
   function createTodo(){
    var doc = {
      text: 'I love programming'
    };
    return Todos.create(doc);
   }
   function shouldBeOk(response) {
      expect(response.ok).toBe(true);
      return response;
   }
   function shouldHaveText(response) {
      expect(response.text).toBe('I love programming');
      return response;
   }
  function shouldNotBeCalled(rejection) {
    self.fail(rejection);
  }

  it('should create a todo', function(done) {
       createTodo()
      .then(shouldBeOk)
      .then(shouldHaveText)
      .catch(shouldNotBeCalled)
      .finally(done);
  });
  it('should update a todo', function(done) {
    createTodo().then(function(response){
      Todos.update(response)
      .then(shouldBeOk)
      .then(shouldHaveText)
      .catch(shouldNotBeCalled)
      .finally(done);
    }) 
  });
   it('should delete a todo item', function(done) {
    createTodo().then(function(response){
      Todos.delete(response.id)
      .then(shouldBeOk)
      .catch(shouldNotBeCalled)
      .finally(done);
    }) 
  });
});
