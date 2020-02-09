
<?php

$url="http://api.airtime.bongolive.co.tz/airtime/transfer";
$token="{API_TOKEN}"

 $headers = array(
     'Content-Type:application/json',
     'Authorization: Bearer '.$token
 );

$dest_addr="{NUMBER}";
$amount ={AMOUNT};
$body = array("dest_addr"=>$dest_addr,"amount"=>$amount);
$body = json_encode($body);
$body = preg_replace('/"([a-zA-Z_]+[a-zA-Z0-9_]*)":/','$1:',$body);

$ch = curl_init($url);

curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
curl_setopt($ch, CURLOPT_CUSTOMREQUEST, "POST");
curl_setopt($ch,CURLOP_POSTFIELDS,$body);
curl_setopt($ch, CURLOPT_HEADER, 1);
curl_setopt($ch, CURLOPT_TIMEOUT, 30);

$output = curl_exec($ch);

$httpcode = curl_getinfo($ch, CURLINFO_HTTP_CODE);
curl_close($ch);

//print response
var_dump($output);

?>