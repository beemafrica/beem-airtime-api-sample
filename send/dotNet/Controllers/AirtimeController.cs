using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Text.Json;
using System.Threading.Tasks;
using AirtimeAPI.Models;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace AirtimeAPI.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class AirtimeController : ControllerBase
    {
        private const string URL_Airtime = "https://apiairtime.bongolive.africa/v1/transfer";
        // POST api/SMS
        [HttpPost]
        [Route("[action]")]
        public ActionResult TransferAirtime([FromBody] Airtime value)
        {
            string DATA = JsonSerializer.Serialize(value);
            HttpWebRequest request = (HttpWebRequest)WebRequest.Create(URL_Airtime);
            request.Method = "POST";
            request.ContentType = "application/json";
            request.ContentLength = DATA.Length;
            StreamWriter requestWriter = new StreamWriter(request.GetRequestStream(), System.Text.Encoding.ASCII);
            requestWriter.Write(DATA);
            requestWriter.Close();

            try
            {
                request.PreAuthenticate = true;
                String username = "";
                String password = "";
                String encoded = System.Convert.ToBase64String(System.Text.Encoding.GetEncoding("ISO-8859-1").GetBytes(username + ":" + password));
                request.Headers.Add("Authorization", "Basic " + encoded);

                WebResponse webResponse = request.GetResponse();
                Stream webStream = webResponse.GetResponseStream();
                StreamReader responseReader = new StreamReader(webStream);
                string response = responseReader.ReadToEnd();
                Console.Out.WriteLine(response);
                responseReader.Close();
                return Ok(response);
            }
            catch (Exception e)
            {
                Console.Out.WriteLine("-----------------");
                Console.Out.WriteLine(e.Message);
                return NotFound();
            }
        }
    }
}
