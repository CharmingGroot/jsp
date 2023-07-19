<%@ page language = "java" contentType = "text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<script defer="defer" src="../assets/pracJs.js"></script>

dd
<script type="text/javascript">
	function hOrderFunc(range){
		console.log('range');
		console.log(range);
	}

	function range(stt, end){
		let arr = [];
		for(let i = stt; i < end; i++){
			arr.push(i);
		}
		return arr;
	}
	
	 hOrderFunc(range(1,10));
</script>
