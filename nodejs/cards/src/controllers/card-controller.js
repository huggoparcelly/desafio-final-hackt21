const neDB = require('../configurations/database')
const { response, request } = require('../configurations/express')
const api = {}


api.findAll = (request, response) => {
    neDB.find({}, (exception, cards) => {
        if (exception) {
            const setence = 'Deu ruim na tentativa de listar todos os cards!'
            console.log(setence, exception)
            response.status(exception.status | 400)
            response.json({ 'mensagem': setence })
        }
        response.json(cards)
    })
}



api.findById = (request, response) => {
    neDB.findOne({_id}, (exception, cards) => {
        if (exception) {
            const setence = 'Deu ruim na tentativa de listar um card!'
            console.log(setence, exception)
            response.status(exception.status | 400)
            response.json({ 'mensagem': setence })
        }
        response.json(cards)
    })
}


api.findPg = (request, response) => {
    neDB.find({}).sort({ name: 1 }).exec((exception, cards) => {
        if (exception) {
            const setence = 'Deu ruim na tentativa de listar todos os cards!'
            console.log(setence, exception)
            response.status(exception.status | 400)
            response.json({ 'mensagem': setence })
        }
        response.json(cards)
    })
}


api.save = (request, response) => {
    const canonical = request.body
    neDB.insert(canonical, (exception, cards) => {
        if (exception) {
            const setence = 'Deu ruim na tentativa de criar um cards!'
            console.log(setence, exception)
            response.status(exception.status | 400)
            response.json({ 'mensagem': setence })
        }
        response.status(201)
        response.json(cards)
    })
}


api.update = (request, response) => {
    neDB.update({_id}, (exception, cards) => {
        if (exception) {
            const setence = 'Deu ruim na tentativa de atualizar um card!'
            console.log(setence, exception)
            response.status(exception.status | 400)
            response.json({ 'mensagem': setence })
        }
        response.status(200)
        response.json(cards)
    })
}

api.remove = (request, response) => {
    neDB.remove({_id}, (exception, cards) => {
        if (exception) {
            const setence = 'Deu ruim na tentativa de deletar um card!'
            console.log(setence, exception)
            response.status(exception.status | 400)
            response.json({ 'mensagem': setence })
        }
        response.status(200)
        response.json(cards)
    })
}


module.exports = api