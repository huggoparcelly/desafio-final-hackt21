const api = require('../controllers/card-controller')

module.exports = (app) => {
    app.route('')
        .get(api.findAll)
        .get(api.findById)
        .get(api.findPg)
        .post(api.save)
        .put(api.update)
        .delete(api.remove)
        


}