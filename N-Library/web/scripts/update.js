/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


let profilePic = document.getElementById("Update-pic");
let inputFile = document.getElementById("Update-file");

inputFile.onchange = function(){
 profilePic.src = URL.createObjectURL(inputFile.files[0]);
}