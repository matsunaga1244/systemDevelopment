function menuClick(value){
	const menu = document.getElementById("menu");

	const element = document.createElement("input");
	element.setAttribute("type", "hidden");
	element.setAttribute("name", "tran");
	element.setAttribute("value", value);

	menu.appendChild(element);

	document.forms["menu"].submit();
}


function search(){
	$.ajax({
		method: 'POST',
		url: '/trainingManage/trList/search',
		data: $('[name="trListForm"]').serialize(),
		dataType: "text",
		xhrFields: {
	        withCredentials: true
	    }
	})
	.done(function(data) {
		if(data != ""){
			alert(data);
		}else{
			document.getElementById("searchResult").contentWindow.location.reload();
		}
	});
}