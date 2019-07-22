window.addEventListener("load", function(){
    var section = document.querySelector("#upload");
    var dropzone = section.querySelector(".drop-zone");
    var percentSpan = section.querySelector(".percent");
    var progressDiv = section.querySelector(".progress");

    dropzone.addEventListener("dragenter", function(e){
        console.log("들어왔니");
       
        //for(var key in e.dataTransfer)
        //console.log(key)
        console.log(e.dataTransfer.types[0]);

        if(e.dataTransfer.types[0] == "Files") {
            dropzone.classList.add("valide");
            dropzone.classList.remove("invalide");
        }
        else{    
        dropzone.classList.add("invalide");
        dropzone.classList.remove("valide");
        }
    });

    dropzone.addEventListener("dragleave", function(e){
        e.preventDefault()
        console.log("나갔니");
        dropzone.classList.remove("invalide", "valide");
    });

     dropzone.addEventListener("dragover", function(e){
         e.preventDefault()
         console.log("위에 있니");

     });

    dropzone.addEventListener("drop", function(e){
        e.preventDefault()
        console.log("드랍");
        dropzone.classList.remove("invalide", "valide");

        var files = e.dataTransfer.files;
        var size = e.dataTransfer.files.length;

        if(size > 1){
            alert("파일 하나씩만 해");
            return;
        }
        
        var file = files[0];
        console.log(file.type);
        var regex = /image\/(jpeg|png|gif)/; //new RegEx("image/(jpeg|png|gif)");
        
        // if(!file.type.match(regex)){
        //     alert("유효파일 형식X");
        //     return;
        // }    
        if(file.size > 100*1024*1024)
            alert("용량커 10메가보다 작은거 넣어");

        //id=newlec&pwd=111... -> String
        var formData = new FormData();	//multipartfile로 보내기
        formData.append("file", file);
        
        var request = new XMLHttpRequest();
        request.addEventListener("load", function(e){
        	if(request.responseText =="ok"){
        		//목록새로 출력하기
        		var req = new XMLHttpRequest();
        		req.addEventListener("load", function(e){
        			alert(req.responseText);
        		});
        		req.open("GET", "../../../file-list");
        		req.send();
        	}
        });

        request.upload.addEventListener("progress", function(e){
        	console.log(percentSpan);
            percentSpan.innerText = Math.round(e.loaded * 100 / e.total);
           
            progressDiv.style.width = Math.round(e.loaded * 100 / e.total)+"%";
        });

        request.open("POST", "../../../upload"); //false 동기 true 비동기
        request.send(formData);	//동기형으로 하면 여기서 멈춤 현상
        
        /*
        load ★★★★★
        error
        abort
        uploadProgress
        */


    });


    /*
    drop zone에서 사용되는 이벤트
    dragenter : 드래그된 리소스가 drop zone에 들어올 때
    dragleave : drop zone에 들어왔던 드래그가 영역 밖으로 나갈 때
    dragover  : drop zone에서 드래그 상태로 이동 중일 때
    drop      : drop zone에서 드랍할 때
    */


});