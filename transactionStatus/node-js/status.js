const axios = require("axios");
const https = require("https");
const btoa = require("btoa");

const api_key = "<api_key>";
const secret_key = "<secret_key>";

const url = "https://apiairtime.beem.africa/v1/transaction-status";

const payload = {
     transaction_id: "<transaction_id>"
 };

axios.post(url, payload, {
         headers: {
             "content-type": "application/json",
              "Authorization": "Basic " + btoa(api_key + ":" + secret_key),
         },
           httpsAgent: new https.Agent({
          rejectUnauthorized: false,
        }),
     })
     .then(resp => console.log(resp.data))
     .catch(err => console.log(err.message));