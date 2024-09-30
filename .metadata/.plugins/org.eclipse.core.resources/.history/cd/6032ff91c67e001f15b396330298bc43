const regex = {
  value: function (selector, msg) {
    var target = $(selector);
    if (!target.val()) {
      alert(msg);
      target.focus();
      return false;
    }
    return true;
  },

  max_length: function (selector, len, msg) {
    var target = $(selector);
    if (target.val().length > len) {
      alert(msg);
      target.val("");
      target.focus();
      return false;
    }
    return true;
  },

  min_length: function (selector, len, msg) {
    var target = $(selector);
    if (target.val().length < len) {
      alert(msg);
      target.val("");
      target.focus();
      return false;
    }
    return true;
  },

  field: function (selector, msg, regx_expr) {
    var target = $(selector);
    if (!target.val() || !regx_expr.test(target.val())) {
      alert(msg);
      target.val("");
      target.focus();
      return false;
    }
    return true;
  },

  equalField: function (origin, compare, msg) {
    var src = $(origin);
    var dsc = $(compare);
    if (src.val() != dsc.val()) {
      alert(msg);
      src.val("");
      dsc.val("");
      src.focus();
      return false;
    }
    return true;
  },

  tel: function (selector, msg) {
    return this.field(
      selector,
      msg,
      /^(01[0-9]{1})([ -]?\d{3,4})([ -]?\d{4})$/
    );
  },

  uid: function (selector, msg) {
    return this.field(selector, msg, /^[a-zA-Z][a-zA-Z0-9]{2,}$/);
  },

  email: function (selector, msg) {
    return this.field(
      selector,
      msg,
      /^[a-zA-Z0-9+-_.]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/
    );
  },
};
