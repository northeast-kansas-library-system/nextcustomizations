SP.IntranetUserJS.txt

----------

Preference name: IntranetUserJS

Type: Free

Options: 70|10

----------

Preference value: 



$(document).ready(function() { 

/* ========== BEGIN Special functions ========== */

//jQuery variables - create multiple variables for uses in other places 
  //url variable
    var url = $(location).attr('href'); 
    console.log("url: " + url);
  //logged_in_branchcode variable
    var logged_in_branchcode = $(".logged-in-branch-code").first().text().trim(); 
    $("body").addClass(logged_in_branchcode); 
    console.log("logged_in_branchcode: " + logged_in_branchcode);
    //logged_in_short_branchcode variable
    var logged_in_short_branchcode = $(".logged-in-branch-code").first().text().trim().substring(0, 4); 
    console.log("logged_in_short_branchcode: " + logged_in_short_branchcode);
  //logged_in_library variable
    var logged_in_library = $(".logged-in-branch-name:first").text().trim();
    console.log("logged_in_library: " + logged_in_library);
  //logged_in_short_library variable
    var logged_in_short_library = $(".logged-in-branch-name:first").text().trim().substring(0, 5); 
    console.log("logged_in_short_library: " + logged_in_short_library);
  //logged_in_staff variable
    var logged_in_staff = $(".loggedinusername").html().trim();
    console.log("logged_in_staff: " + logged_in_staff);
  //timestamp_now and date_now variables
    //(timestamp_now = date now + time now)
    //(date_now = date now)
      var tsnow = new Date($.now());
      var tsday = ("0" + tsnow.getDate()).slice(-2);
      var tsmonth = ("0" + (tsnow.getMonth() + 1)).slice(-2);
      var tsyear = ("0" + (tsnow.getFullYear())).slice(-4);
      var tshour = (tsnow.getHours());
      var tsminute = ("0" + tsnow.getMinutes()).slice(-2);
      var timestamp_now = (tsyear) + "-" + (tsmonth) + "-" + (tsday) + " - " + (tshour) + ":" + (tsminute);
      var date_now = (tsyear) + "-" + (tsmonth) + "-" + (tsday);
      console.log("timestamp_now: " + timestamp_now);
      console.log("date_now: " + date_now);
  //borrower_home and borrower_short_home variables (only appears on pages related to a borrower account)
    //borrower_home = full name of borrower's home library
    //borrower_short_home = first 5 characters of borrower's home library
        var borrower_home_raw = $('.patronlibrary').text().split(': ');
        var borrower_home = borrower_home_raw[1] || "no_borrower";
        console.log("borrower_home: " + borrower_home); 
        var borrower_short_home = borrower_home.substring(0, 5);
        console.log("borrower_short_home: " + borrower_short_home); 
  //staff_note variable 
    var staff_note = (logged_in_staff + " at " + logged_in_library + " on " + timestamp_now);
    console.log("staff_note: " + staff_note);

//Create functions that can be called upon by other jQuery
  //Creates IntranetuserJS.toHtml function 
    //Used by IntranetuserJS.html_borrower_messages
      $.fn.toHtml=function(){ 
        return $(this).html($(this).text()); 
      };
 
/* ========== END Special functions ========== */

/* ========== Special code for test server ========== */
  
//Creates custom instructions if URL= "staff.nekls-test"
  if (url.indexOf('staff.nekls-test') != -1) { 
    
    //Adds "Test server" background watermark
      $('body').attr('style', 'background-image: url("https://raw.githubusercontent.com/northeast-kansas-library-system/nextimages/master/test.server.blue.svg"); background-size: 25%'); 
    //Adds "Test server" warning message
      $('#breadcrumbs').after('<div><h1 id="test_server_warning" align="center" style="padding: 5px;">! TEST SERVER !</h1></div>'); 
      $('#login').before('<div><h1 id="test_server_warning" align="center" style="padding: 5px;">! TEST SERVER !</h1></div>');
    //Adds test server screenshot button (Clicking button temporarily removes watermark and "Test server" warning message)
      $('#user-menu').append('<button id="test_toggle" type="button" class="btn btn-custom-info" style="display: inline; "><i class="fa fa-camera" aria-hidden="true"></i></button>');  
    //Adds function to screenshot button
      $("#test_toggle").click(function() { 
        $('body').css('background-image', 'none');
        $('.special_alert').css('display','none');
        $('#test_server_warning').css('display','none');
        $('#test_toggle').css('display','none');
      });
    
    } 

/* ========== END Special code for test server ========== */

/* ========== Alerts ========== */
  
// IntranetUserJS.special_alert - requires IntranetUserCSS.special_alert - puts message on all pages in staff client
  //Set to "block" to make message visible - set to "none" to disable message
    var special_alert_display = "block"
  //Sets the contents of the message
    var special_alert_content = "This is just a test"
  //positions the message on all pages in the staff interface
    $('#sub-header').after('<div><h3 class="special_alert" style="display: ' + special_alert_display + ' ;">' + special_alert_content + '</h3></div>'); 

/* ========== Alerts - END ========== */

/* ========== All pages ========== */ 
  
//IntranetUserJS.reLogo - requires IntranetUserCSS.reLogo
  //Replace Koha logo with "Next" logo in typeface
    $("#logo").html('<p>NE<span class="next_x">X</span>T</p>');

//BEGIN open left side navbar drop-downs on hover 
  $(".navbar-nav li.dropdown:lt(3)").hover(function() { 
    $(this).addClass("open"); 
  }, function() { 
    $(this).removeClass("open"); 
  }); 

//BEGIN Fix searches by striping parenthesis and semicolons from links 
  $('a[href*="search.pl"]').attr('href', function(_, v) { 
    return v.replace(/(\w)(\(|\)|\;|\!)(\w)/g, '$1 $3'); 
  }).attr('href', function(_, v) { 
    return v.replace(/(\(|\)|\;|\!)/g, ''); 
  }); 

/* ========== END All pages ========== */

/* ========== BEGIN Unsorted bits and pieces ========== */

//Home
  //Widen the area for the bigbuttons on the home page (mainpage.pl)
    $('#main_intranet-main .col-lg-6').addClass('col-lg-8').removeClass('col-lg-6');

//Home > Circulation > Checkouts > [BORROWERNAME (CARDNUMBER)] (circ/circulation.pl?borrowernumber=[BORROWERNUMBER])
//Home > Patrons > [BORROWERNAME (CARDNUMBER)] > Details (members/moremember.pl?borrowernumber=[BORROWERNUMBER])
  //IntranetuserJS.html_borrower_messages - requires IntranetuserJS.toHtml
  //Allows HTML content in borrower messages
    $('#messages span').each(function() { 
      $(this).toHtml(); 
    }); 

//Home > Reports > Guided reports wizard (reports/guided_reports.pl?reports=[REPORTID]&phase=Run this report)
//Home > Reports > Guided reports wizard > Saved reports (reports/guided_reports.pl?phase=Use saved)
//Home > Reports > Guided reports wizard > Saved reports > [REPORTNAME (REPORTID) > Run (reports/guided_reports.pl?reports=[REPORTID]&phase=Run this report)
  //html_report_notes (requires "toHtml" function)
  //Allows HTML in report notes
    $('#table_reports tr td:nth-child(7), .col-sm-10 > main:nth-child(1) > form:nth-child(4) > p:nth-child(4), .page-section > p:nth-child(1)').each(function() { 
      $(this).toHtml(); 
    }); 

//Home > Cataloging > Edit TITLE > items (cataloguing/additem.pl?biblionumber=n)
  //Limit the number of copies that can be added to a biblio using the "Add multiple copies of this item" button
    $('#cat_additem #number_of_copies').attr('type','number').attr('max','10');

//Home > Reports > Guided reports wizard > Saved reports (reports/guided_reports.pl?phase=Use saved) 
  //IntranetUserJS.show_report_tabs_and_table - requires IntranetUserCSS.show_report_tabs_and_table
  //Show tabs and table on reports page after table has finished loading
    $('#rep_guided_reports_start #tabs,#circ_circulation #patronlists,#acq_suggestion #suggestiontabs').css('display','block'); 

//Home > Cataloging > Add MARC record 
//Home > Cataloging > Editing {title} (Record number {biblionumber}) 
  //BEGIN Add labels to Marc tabs 
    $('#cat_addbiblio .toolbar-tabs-container a[href="#tab0XX_panel"]').append('<br />Control and coded fields'); 
    $('#cat_addbiblio #tab0XX_panel h3').append(' - Control and coded fields'); 
    $('#cat_addbiblio .toolbar-tabs-container a[href="#tab1XX_panel"]').append('<br />Main entry'); 
    $('#cat_addbiblio #tab1XX_panel h3').append(' - Main entry'); 
    $('#cat_addbiblio .toolbar-tabs-container a[href="#tab2XX_panel"]').append('<br />Title and edition'); 
    $('#cat_addbiblio #tab2XX_panel h3').append(' - Title and edition'); 
    $('#cat_addbiblio .toolbar-tabs-container a[href="#tab3XX_panel"]').append('<br />Physical description'); 
    $('#cat_addbiblio #tab3XX_panel h3').append(' - Physical description'); 
    $('#cat_addbiblio .toolbar-tabs-container a[href="#tab4XX_panel"]').append('<br />Series'); 
    $('#cat_addbiblio #tab4XX_panel h3').append(' - Series'); 
    $('#cat_addbiblio .toolbar-tabs-container a[href="#tab5XX_panel"]').append('<br />Notes'); 
    $('#cat_addbiblio #tab5XX_panel h3').append(' - Notes'); 
    $('#cat_addbiblio .toolbar-tabs-container a[href="#tab6XX_panel"]').append('<br />Subject access'); 
    $('#cat_addbiblio #tab6XX_panel h3').append(' - Subject access'); 
    $('#cat_addbiblio .toolbar-tabs-container a[href="#tab7XX_panel"]').append('<br />Added and linking entry'); 
    $('#cat_addbiblio #tab7XX_panel h3').append(' - Added and linking entry'); 
    $('#cat_addbiblio .toolbar-tabs-container a[href="#tab8XX_panel"]').append('<br />Series added entry<br />and electronic access'); 
    $('#cat_addbiblio #tab8XX_panel h3').append(' - Series added entry and electronic access'); 
    $('#cat_addbiblio .toolbar-tabs-container a[href="#tab9XX_panel"]').append('<br />Koha related'); 
    $('#cat_addbiblio #tab9XX_panel h3').append(' - Koha related'); 

//Home > Cataloging > Editing {Title} (Record number {biblionumber}) > Items (/cataloguing/additem.pl?biblionumber={biblionumber}) 
  //BEGIN prevent edit and delete of non-local items 
  //CSS_THAT_DEPENDS_ON_THIS IntranetUserCSS "adds light color to local rows in add/edit items" requires this to work 
/*    $('#cataloguing_additem_itemlist .dropdown-menu a:contains("Edit")').addClass('edit'); 
    $('#cataloguing_additem_itemlist tr').addClass('non_local'); 
    $('#cataloguing_additem_itemlist td:contains(' + logged_in_short_library + ')').parent().removeClass('non_local').addClass('local'); 
    $('#cataloguing_additem_itemlist .delete, #cataloguing_additem_itemlist .edit').hide(); 
    $('#cataloguing_additem_itemlist .local .delete, #cataloguing_additem_itemlist .local .edit, .linktools').show(); 
    $('.non_local td:not(:first-child').click(function( event ) { 
      event.preventDefault(); 
      event.stopImmediatePropagation(); 
      event.stopPropagation(); 
    }); 
    $('#cat_additem #itemst').on('init.dt', function() { 
      $('#itemst_filter input').val(logged_in_short_library).keyup(); 
      $('.dt-button.dt_button_clear_filter .dt-button-text').addClass('next_btn next_green'); 
    }); 
    $('#cat_additem #cataloguing_additem_itemlist').before('<p class="next_btn next_green" style="font-size: 1.25em">To see items from other libraries, click on the "Clear filter" button</p>'); 
*/
//Home > Patrons > Add patron ([borrowercategory]) (members/memberentry.pl?op=add&categorycode=)
//Home > Patrons > [borrowername] ([borrowercardnumber]) > Modify patron ([borrowercategory]) (members/memberentry.pl?op=modify&destination=circ&borrowernumber=)
  //Force Item due and Advance notice to auto-select "Digests only" when selected

    if (url.indexOf('memberentry.pl') != -1) { 

      var email1_var = document.getElementById('email1');
      var sms1_var = document.getElementById('sms1');
      var email2_var = document.getElementById('email2');
      var sms2_var = document.getElementById('sms2');
        
      $('#email1, #sms1, #digest1').change(function() {
        if( (email1_var.checked == true) || (sms1_var.checked == true) ) {
          $('#digest1').prop('checked', 'true').delay('2000');
        }
      });

      $('#email2, #sms2, #digest2').change(function() {
        if( (email2_var.checked == true) || (sms2_var.checked == true) ) {
          $('#digest2').prop('checked', 'true').delay('2000');
        }
      });

    } 
  
//Home > Patrons > Add patron ([borrowercategory]) (members/memberentry.pl?op=add&categorycode=)
//Home > Patrons > [borrowername] ([borrowercardnumber]) > Modify patron ([borrowercategory]) (members/memberentry.pl?op=modify&destination=circ&borrowernumber=)
  //Message preference buttons
    $("#patron_messaging_prefs_lgd").after("<p id='emailbuttons' style='margin: 5px'><button id='clearemail' type='button' style='margin: 5px'>Clear all email</button><button id='defaultemail' type='button' style='margin: 5px'>Reset e-mail defaults</button></p>"); 
    $("#clearemail").click(function() { 
      $("#email1, #email2, #email4, #email5, #email6, #digest1, #digets2").prop('checked', true); 
      $("#memberentry_messaging_prefs table select option[value=3]").attr("selected", "selected"); 
      $('#email1, #email2, #email4, #email5, #email6, #digest1, #digets2').trigger('click').delay('2000');
    }); 
  
    $("#defaultemail").click(function() { 
      $("#email1, #email2, #digest1, #digest2, #email4, #email5, #email6").prop('checked', false); 
      $("#email1, #email2, #email4, #email6").trigger('click'); 
      $('#digest1, #digest2').trigger('click').delay('2000');
      $("#memberentry_messaging_prefs table select option[value=3]").attr("selected", "selected"); 
    }); 
  
//Home > Patrons > Add patron ([borrowercategory]) (members/memberentry.pl?op=add&categorycode=)
  //BEGIN SMS changes in the staff client 
    //BEGIN Hides SMS number and all SMS checkboxes when page is loaded 
      $("#SMSnumber").parent().hide(); 
      $("#sms1, #sms2, #sms4, #sms5, #sms6").attr("disabled", "disabled"); 
   
    //BEGIN Show SMS number if provider is not null and clear number and all SMS checkboxes if the provider is changed to null 
      $(".pat").on("mousemove change click keyup", function() { 
        if ($("#sms_provider_id").val() != "") { 
          $("#SMSnumber").parent().show("slow"); 
        } else { 
          $("#SMSnumber").parent().hide("slow"); 
          $("#SMSnumber").val(""); 
          $("#smsbuttons").hide(); 
          $("#sms1, #sms2, #sms4, #sms5, #sms6").attr("disabled", "disabled"); 
          $("#sms1, #sms2, #sms4, #sms5, #sms6").prop("checked", false); 
        } 
      }); 
   
    //BEGIN Enable SMS checkboxes only if SMS number is 10 digits and force SMS number entry to numerals only - no punctuation, alphanumeric characters, or spaces 
      $("#SMSnumber").attr('maxlength', '10'); 
      $("#pat_memberentrygen").on("mousemove change click keyup", function() { 
        if ($("#SMSnumber").val().length == 10) { 
          $("#sms1, #sms2, #sms4, #sms5, #sms6").removeAttr("disabled"); 
          $("#smsbuttons").fadeIn("slow"); 
        } else { 
          $("#sms1, #sms2, #sms4, #sms5, #sms6").attr("disabled", "disabled"); 
          $("#sms1, #sms2, #sms4, #sms5, #sms6").prop("checked", false); 
          $("#smsbuttons").fadeOut("slow"); 
        } 
      }); 
   
    //Wraps message preferences table with an ID
      // required for 'Hides "Digests only" column on message preferences table' CSS
        $('th:contains("Days in advance")').parents().eq(2).wrap('<div id="messagetable"></div>'); 

    //Moves SMS provider and number above the table 
      $("#memberentry_messaging_prefs label:contains('SMS number:')").parent().wrap('<div id="smsnumbermove"></div>'); 
      $("#memberentry_messaging_prefs label:contains('SMS provider:')").parent().wrap('<div id="smsprovidermove"></div>'); 
      $("#smsnumbermove").prependTo("#messagetable").parent(); 
      $("#smsprovidermove").prependTo("#messagetable").parent(); 
   
    //BEGIN Rename SMS "Text messaging" for the sake of staff who don't know what SMS stands for 
      $('#memberentry_messaging_prefs label, #messagetable th').each(function() { 
        var text = $(this).text(); 
        $(this).text(text.replace('SMS', 'Text message')); 
      });     
  

//Home > Tools > LIBRARY_NAME calendar (/cgi-bin/koha/tools/holidays.pl) 
  //Libraries can only modify their own calendars (requires "logged_in_short_branchcode variable" variable) 
    $('#tools_holidays #branch option:not(:contains(' + logged_in_short_library + '))').hide(); 
  //Libraries can only copy their calendar to their own branches
    $('#tools_holidays #branchcode option:not(:contains(' + logged_in_short_library + '))').hide(); 
  //BEGIN make holiday title required 
    $('#tools_holidays #newHoliday #title').attr('required', 'true').after('<span class="required">Required</span>');   
  //BEGIN add description with name and date to holidays (requires TIMESTAMP special function) 
    $(".cancel.hidePanel.newHoliday").prev().on("click", function() { 
      $("#newDescription").val(function(index, val) { 
        return val + " - closed date added by " + staff_note; 
      }); 
    });
  //Disable "Holiday repeated yearly on the same date," "Holidays repeated yearly on a range," "Copy to all libraries"
    $('#tools_holidays #newOperationYear, #tools_holidays #newOperationFieldyear, #tools_holidays #allBranches').parent().hide();
  //Rename "Holiday" to "Closed date"
    if (url.indexOf('holidays.pl') != -1) { 
      $('#tools_holidays label:contains("Holiday"), #tools_holidays label:contains("holiday"), #tools_holidays h3:contains("holiday"), #tools_holidays .key:contains("Holiday"), #tools_holidays .key:contains("holiday"), #tools_holidays .hint:contains("holiday")').each(function() {
        var content = $(this).html(); 
        content = content.replace('Holiday','Closed date'); 
        content = content.replace('holiday','closed date');
        $(this).html(content); 
      });
    }

























/* ========== END Unsorted bits and pieces ========== */

/* Special message for holds history bug error message */
/* Koha bug 34609 https://bugs.koha-community.org/bugzilla3/show_bug.cgi?id=34609 */

  //Add id to error message
  $('#err_500 h1:contains("An error has occurred!")').parent().wrap('<div id="500_error_message"></div>');

  //Add message in front of error message suggesting where to find good data
    if (url.indexOf('members/holdshistory.pl') != -1) { 
      $('#err_500 #500_error_message').prepend('<div><h3 align="center" style="background-color: var(--c_medium); color: var(--t_medium); padding: 5px; ">Holds history is broken in some cases when titles have been deleted from the catalog.<br /><br />You can run <a href="https://staff.nextkansas.org/cgi-bin/koha/reports/guided_reports.pl?reports=2801&phase=Run%20this%20report" target="_blank">report #2801</a> as an alternative way to see a borrower\'s hold history</h3></div>'); 
    } 
  
/* END special message for holds history bug */






















































































































































}); 

























