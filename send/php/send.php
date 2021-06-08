<?php

$url="https://apiairtime.beem.africa/v1/transfer";

$api_key='<api_key>';
$secret_key = '<secret_key>';

$dest_addr="<dest_addr>";
$amount ="<amount>";
$ref ="<reference_id>";
$body = array('dest_addr'=>$dest_addr,'amount'=>$amount, 'reference_id'=>$ref);

$ch = curl_init($url);
$option = array(
    CURLOPT_POST => TRUE,
    CURLOPT_RETURNTRANSFER => TRUE,
    CURLOPT_HTTPHEADER => array(
        'Authorization:Basic ' . base64_encode("$api_key:$secret_key"),
        'Content-Type: application/json'
    ),
    CURLOPT_POSTFIELDS => json_encode($body));

error_reporting(E_ALL);
ini_set('display_errors', 1);
curl_setopt($ch, CURLOPT_SSL_VERIFYHOST, 0);
curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, 0);
curl_setopt_array($ch,$option);

$response = curl_exec($ch);
$httpcode = curl_getinfo($ch, CURLINFO_HTTP_CODE);

// Check for errors
if($response === FALSE){
        echo $response;

    die(curl_error($ch));
}
var_dump($response);