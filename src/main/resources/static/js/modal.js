const modal = function (e) {
	$('.complaintImage').click(function () {
		$('#modalImage').attr('src', e.src);
		$('.ui.modal').modal('show');
	});
};
