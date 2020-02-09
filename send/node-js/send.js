
const axios = require("axios");
const url = "https://api.airtime.bongolive.co.tz/airtime/transfer";

const payload = {
    dest_addr: {NUMBER},
     amount: {AMOUNT}
 };
const token = ""
function send(){
axios.post(url, payload,{
         headers: {
             "content-type": "application/json",
              authorization: "bearer " + token
         }
     })
     .then(resp => console.log(resp.data))
     .catch(err => console.log(err.message));
    }
    send();