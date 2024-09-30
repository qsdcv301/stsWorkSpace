$(document).ready(function () {
  $("#gradeAdd").click(function (e) {
    e.preventDefault();
    let index = $(".gradeItem .row").length;
    let gradeHtml =
      "<div class='row pb-3 mt-3 border-bottom'>" +
      "<label class='col-2 text-center'>" +
      index +
      "</label>" +
      "<input type='text' class='form-control col-9' name='grade-" +
      index +
      "' value=''>" +
      "</div>";
    $(".gradeItem").append(gradeHtml);
  });
  $("#gradeRemove").click(function (e) {
    e.preventDefault();
    if ($(".gradeItem .row").length > 0) {
      $(".gradeItem .row").last().remove();
    }
  });
});
