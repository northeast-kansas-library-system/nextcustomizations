/* If you have a large number of registered borrowers, doing a search for "A" or "S" or other short strings can cause the system to crash.  This prevents staff from attempting a search in the check-out input box for strings less than 4 characters long - which helps prevent time-outs.  This problem only exists in the check-out input.  If staff need to do a search for a shorter string, they can do that in the patron search input which uses the datatables plug-in to prevent the same problem. */

 //BEGIN Prevent Checkout search for short strings
  $("#patronsearch").on('submit', function(e){
   e.preventDefault();
   var len = $('#findborrower').val().length;
   if (len > 3 && len > 1) {
    this.submit();
    } else {
    alert("Please enter four or more characters to perform a checkout search to avoid returning too many results");
   }
  });
