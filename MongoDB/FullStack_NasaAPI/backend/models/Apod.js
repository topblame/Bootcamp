const mongoose = require("mongoose"); // ODM 라이브러리

const ApodSchema = new mongoose.Schema({
  date: String,
  title: String,
  url: String,
  explanation: String,

});

module.exports = mongoose.model('Apod', ApodSchema);