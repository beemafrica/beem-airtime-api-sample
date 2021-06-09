const axios = require('axios');
const url = `https://apitopup.beem.africa/v1/credit-balance?app_name=<app_name>`;
const https = require('https');
const btoa = require('btoa');

const api_key = '<api_key>';
const secret_key = '<secret_key>';

function checkbalance() {
axios
.get(url, {
headers: {
'Content-Type': 'content_type',
Authorization: 'Basic ' + btoa(api_key + ':' + secret_key),
},
httpsAgent: new https.Agent({
rejectUnauthorized: false,
}),
})
.then((response) => console.log(response.data))
.catch((error) => console.error(error.response.data));
}
checkbalance();