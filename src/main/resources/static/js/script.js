window.onload = function (){
    var item = document.getElementsByClassName("item");
    var it = item[0].getElementsByTagName("div");

    var content = document.getElementsByClassName("content");
    var con = content[0].getElementsByTagName("div");

    for (let i=0;i<it.length;i++){
        it[i].onclick = function(){
            switch (i){
                case 0:
                    window.location.href='index.html';
                    break;
                case 1:
                    window.location.href='register.html';
                    break;
                default:
                    break;
            }

        }
    }
}