/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validate(){

    if($('#upload_image')[0].files.length === 0){
        alert("Attachment Required");
        $('#upload_image').focus();

        return false;
    }
}
