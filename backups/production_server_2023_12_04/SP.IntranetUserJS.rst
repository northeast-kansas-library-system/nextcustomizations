XX.IntranetUserJS.txt

----------

Preference name: IntranetUserJS

Type: Free

Options: 70|10

----------

Preference value: 



$(document).ready(function() {
  


  /* ========== Special code for test server ========== */
    
    //Creates URL variable
      var url = $(location).attr('href'); 
      console.log("url: " + url);
    
      //Creates custom instructions if URL= "staff.nekls-test"
        if (url.indexOf('staff.nekls-test') != -1) { 
        
        //Adds "Test server" background watermark
          $('body').attr('style', 'background-image: url("https://raw.githubusercontent.com/northeast-kansas-library-system/nextimages/master/test.server.blue.svg"); background-size: 25%'); 
        //Adds "Test server" warning message
          $('#breadcrumbs').after('<div><h1 id="test_server_warning" align="center" style="padding: 5px;">! TEST SERVER !</h1></div>'); 
          $('#login').before('<div><h1 id="test_server_warning" align="center" style="padding: 5px;">! TEST SERVER !</h1></div>');
        
        //Adds test server screenshot button
          $('#user-menu').append('<button id="test_toggle" type="button" class="btn btn-custom-info" style="display: inline; "><i class="fa fa-camera" aria-hidden="true"></i></button>');  
        
        //Adds function to screenshot button
          $("#test_toggle").click(function() { 
            $('body').css('background-image', 'none');
            $('#upgrade_note').css('display','none');
            $('#test_server_warning').css('display','none');
            $('#test_toggle').css('display','none');
          });
        
        } 
  
  /* ========== END Special code for test server ========== */
    
  /* Special message for holds history bug error message */
  
  //Add id to error message
    $('#err_500 h1:contains("An error has occurred!")').parent().wrap('<div id="500_error_message"></div>');
  
  //Add message in front of error message suggesting where to find good data
    if (url.indexOf('members/holdshistory.pl') != -1) { 
      var fivehundred_error_report = "2801";
      $('#err_500 #500_error_message').prepend('<div><h3 align="center" style="background-color: var(--c_medium); color: var(--t_medium); padding: 5px; ">Holds history is broken in some cases when titles have been deleted from the catalog.<br /><br />You can run <a href="https://staff.nextkansas.org/cgi-bin/koha/reports/guided_reports.pl?reports=' + fivehundred_error_report + '&phase=Run%20this%20report" target="_blank">report #2801</a> as an alternative way to see a borrower\'s hold history</h3></div>'); 
    } 
    
  /* END special message for holds history bug */
  
  /* ========== Alerts ========== */
    
  //Alert all - Text and hover function - appears on all pages
    $('#sub-header').after('<div><h3 align="center" class="alert_all" style="background-color: var(--c_medium); color: var(--t_medium); padding: 5px; display: none;">You must clear the browser cache before logging in on Sunday, August 27 or Monday, August 28.</h3></div><h3 align="center"><a href="https://northeast-kansas-library-system.github.io/nextsteps/cataloging_basics/index.html" target="_blank">Basic cataloging guide</a></h3></div>'); 
    $('.alert_all').hover(function() { 
      $('.alert_all').css({'background-color': '#dec11f', 'color': 'black'});
      }, function(){ 
      $('.alert_all').css({'background-color': 'var(--c_medium)', 'color': 'var(--t_medium)'}); 
    }); 
  
  /* ========== Alerts - END ========== */
  
  /* ========== All pages ========== */ 
  
  //Home
    //Widen the area for the bigbuttons on the home page (mainpage.pl)
      $('#main_intranet-main .col-lg-6').addClass('col-lg-8').removeClass('col-lg-6');
  
    //Replace Koha logo
      $("#logo").html('<p style="font-size: 1.5em !important; font-weight: 750; margin-top: 15.75px;"><span id="next_logo" style="color: #1f9bde !important;">NE</span><span style="color: #0157b9 !important;">X</span><span id="next_logo" style="color: #1f9bde !important;">T</span></p>');
  
    //Makes default catalog search a "Contains" search
      $('#patron_search #searchtype option[value="contain"]').attr('selected','selected');
    
    //BEGIN Creates to_html function 
      $.fn.toHtml=function(){ 
        return $(this).html($(this).text()); 
      }; 
    
    //Special functions - create variables for multiple uses 
      //Special function BRANCHCODE 
        var loglibbc = $(".logged-in-branch-code").first().text().trim(); 
        console.log("loglibbc: " + loglibbc);
        $("body").addClass(loglibbc); 
      //Special function SHORTBRANCHCODE 
        var sloglibbc = $(".logged-in-branch-code").first().text().trim().substring(0, 4); 
        console.log("sloglibbc: " + sloglibbc);
      //Special function LIBNAME 
        var loglibname = $(".logged-in-branch-name:first").text().trim();
        console.log("loglibname: " + loglibname);
      //Special function SHORTNAME 
        var shortloglibname = $(".logged-in-branch-name:first").text().trim().substring(0, 5); 
        console.log("shortloglibname: " + shortloglibname);
      //Logged in user name
        var logged_in_user = $(".loggedinusername").html().trim();
        console.log("logged_in_user: " + logged_in_user);
    //Special function - prnow and repnow
      //BEGIN adds date in YYYY.MM.DD HH:MM and YYYY-MM-DD format as saved variables - very useful
        var tsnow = new Date($.now());
        var tsday = ("0" + tsnow.getDate()).slice(-2);
        var tsmonth = ("0" + (tsnow.getMonth() + 1)).slice(-2);
        var tsyear = ("0" + (tsnow.getFullYear())).slice(-4);
        var tshour = (tsnow.getHours());
        var tsminute = ("0" + tsnow.getMinutes()).slice(-2);
        var prnow = (tsyear) + "-" + (tsmonth) + "-" + (tsday) + " - " + (tshour) + ":" + (tsminute);
        var repnow = (tsyear) + "-" + (tsmonth) + "-" + (tsday);
        var next_year_full_date = new Date(new Date().setFullYear(new Date().getFullYear() + 1));
        var next_year = ("0" + (next_year_full_date.getFullYear())).slice(-4);
        var one_year_from_now = (next_year) + "-" + (tsmonth) + "-" + (tsday);
        console.log("prnow: " + prnow);
        console.log("repnow: " + repnow);
        console.log("one_year_from_now: " + one_year_from_now);
    //Borrower hom library
        var borrower_home_raw = $('.patronlibrary').text().split(': ');
        var borrower_home_library = borrower_home_raw[1];
        console.log("borrower_home_library: " + borrower_home_library);
        
    
    //BEGIN 
      var user_note = (logged_in_user + " at " + loglibname + " on " + prnow);
      console.log("user_note: " + user_note);
    
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
  
  /* -- END All pages -- */
  
  //Home > Cataloging > Edit TITLE > items (cataloguing/additem.pl?biblionumber=n)
    //Limit the number of copies that can be added to a biblio using the "Add multiple copies of this item" button
      $('#cat_additem #number_of_copies').attr('type','number').attr('max','10');
  
  //Home > Reports > Guided reports wizard > Saved reports (reports/guided_reports.pl?phase=Use saved) 
    //Report show tabs and table after table has finished loading (requires  IntranetUserCSS "Report show tabs and table" )
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
      $('#cataloguing_additem_itemlist tr').addClass('non_local'); 
      $('#cataloguing_additem_itemlist td:contains(' + shortloglibname + ')').parent().removeClass('non_local').addClass('local'); 
      $('#cat_additem #itemst').on('init.dt', function() { 
        $('#itemst_filter input').val(shortloglibname).keyup(); 
        $('.dt-button.dt_button_clear_filter .dt-button-text').addClass('next_label_light'); 
      }); 
      $('#cat_additem #cataloguing_additem_itemlist').before('<p class="next_label_light embiggen_10">To see items from other libraries, click on the "Clear filter" button</p>'); 
  
  //Home > Reports (/cgi-bin/koha/reports/reports-home.pl) 
    //BEGIN add large "Saved reports" button to the top of the menu 
      $('#rep_reports-home div.col-xs-6:nth-child(1)').prepend('<fieldset class="brief"> <h2> <a href="/cgi-bin/koha/reports/guided_reports.pl?phase=Use%20saved"><i class="fa fa-list"></i> Saved reports</a> </h2></fieldset>'); 
  
  //Home > Circulation > Check in (/cgi-bin/koha/circ/returns.pl) 
    //BEGIN add row count to table 
      $('#checkedintable tr:first').prepend('<th>Checkin row count</th>'); 
      $('#checkedintable tr:gt(0)').prepend('<td></td>'); 
      $('#checkedintable tbody tr').each(function(idx) { 
        $(this).children().first().html(idx + 1); 
      });
  
  //Home > Reports › Guided reports wizard › Saved reports › -REPORTNAME- Report 
    //BEGIN renders notes on reports in HTML 
      //Requires IntranetUserJS "to_html" function 
        $('#table_reports tr td:nth-child(7), .col-sm-10 > main:nth-child(1) > form:nth-child(4) > p:nth-child(4), .page-section > p:nth-child(1)').each(function() { 
          $(this).toHtml(); 
        }); 
  
  //Home > Reports > Guided reports wizard (reports/guided_reports.pl?reports=[REPORTNUMBER]&phase=Run this report)
    //BEGIN Auto-fill some reports data
      //Auto-input today's date unless it's "date1"
        $('#rep_guided_reports_start .col-sm-10 input.flatpickr').val(repnow);
      //Input January 1, 2000 as "date1"
        $("#rep_guided_reports_start li label:contains('date1')").next().val('01/01/2000');
      //prefill wildcard when called for
        $("label:contains('or a % symbol')").next().val("%");
  
  //Home > Administration > Libraries > Modify library 
    //BEGIN Branch input - relabel address line input 
      $("#admin_branches.admin label[for='branchaddress1']").html("Mailing address:"); 
      $("#admin_branches.admin label[for='branchaddress2']").html("Street address /<br />Physical address:"); 
      $("#admin_branches.admin label[for='branchaddress3']").html("Director / ILL contact:"); 
      $("#admin_branches.admin label[for='branchcountry']").html("KLE Code:"); 
  
  //Home > Catalog > [TITLE] > Place a hold (reserve/request.pl?biblionumber=[BIBLIONUMBER]&borrowernumber=[BORROWERNUMBER])
    //Restrict item specific requests to staff at the district that owns the item
      $('#circ_request #requestspecific input[type="radio"]').addClass('hidden');
      $('#circ_request #requestspecific td:nth-child(5):contains("' + shortloglibname + '")').parent().addClass('local_copy');
      $('#circ_request #requestspecific .local_copy input').removeClass('hidden');
  
  
  /* ========== Put holds queue and alerts on the leftside of the home page ========== */ 
  
  //Home 
    //BEGIN holds queue, MIT, and cnx requests buttons on staff interface main page 
      if ( $('#main_intranet-main').length ) { 
        var to_do_dashboard_report = "3759"; 
        $.getJSON('/cgi-bin/koha/svc/report?id=' + to_do_dashboard_report + '&phase=Run+this+report&param_name=branchcode+1&sql_params=' + loglibbc + '&param_name=branchcode+2&sql_params=' + loglibbc + '&param_name=branchcode+3&sql_params=' + loglibbc + '&param_name=branchcode+4&sql_params=' + loglibbc, function(data) { 
          $.each(data, function(index, value) { 
            var to_do_dashboard = value; 
            $('#area-pending').before(to_do_dashboard); 
          }); 
        }); 
      }
  
  //Home (koha/mainpage.pl)
    //Move "pending alerts" above news and add "Alerts" title
      $('#area-pending').prependTo('.col-sm-3').css('width','auto').prepend('<h4 style="padding: 1.1em; background-color: var(--c_medium); margin: 0; text-align: center; border-radius: 6px;"><span class="news_title">Alerts</span></h4>'); 
    //Style alerts info
      $('div.pending-info').css('background-color','var(--c_light)').css('border-radius','6px').css('margin-left','2px').css('text-align', 'center');
      $('div.pending-info a').prepend('<i class="fa fa-bell"></i>').css('font-size','1.1em'); 
    //Only show suggestions for this library
      $('#suggestions_pending').contents().filter(function() { 
        return this.nodeType == Node.TEXT_NODE; 
      }).wrap("<span class='text_node'></span>");
    //Eliminate slash
      $('.text_node').remove();
    //Change message text
      $('#pendingsuggestions').each(function(){
        var suggestion_content = $(this).html(); 
        suggestion_content = suggestion_content.replace(loglibname, 'For this library'); 
        $(this).html(suggestion_content); 
      }); 
    //Then hide "All libraries" suggestions
      $('#all_pendingsuggestions').parent().prepend('<br />');
    //Add label to "Suggestions" area
      $('#suggestions_pending > a:nth-child(1) > i:nth-child(1)').before('<h4>Suggestions</h4>');
  
  //Home (koha/mainpage.pl)
    //BEGIN hide "Pending suggestions" if none are at this library 
      $('#main_intranet-main #area-pending').addClass('hidden'); 
      $('#main_intranet-main #suggestions_pending').addClass('hidden'); 
      if ($('#main_intranet-main').length) { 
        $.getJSON("/cgi-bin/koha/svc/report?id=3620&phase=Run+this+report&param_name=Enter+branchcode&sql_params=" + loglibbc + "&annotated=1", function(data) { 
          var hiddenclass0 = data[0].class; 
          $('#suggestions_pending').removeClass( hiddenclass0 ); 
          $('#main_intranet-main #area-pending').removeClass( hiddenclass0 ); 
        }); 
      } 
  
  //Home  (koha/mainpage.pl)
    //BEGIN hide "Patrons requesting modifications" if none are at this library 
      $('#main_intranet-main #patron_updates_pending').addClass('hidden'); 
      if ($('#main_intranet-main').length) { 
        $.getJSON("/cgi-bin/koha/svc/report?id=3621&phase=Run+this+report&param_name=Enter+branchcode&sql_params=" + loglibbc + "&annotated=1", function(data) { 
          var hiddenclass1 = data[0].class; 
          $('#patron_updates_pending').removeClass( hiddenclass1 ); 
          $('#main_intranet-main #area-pending').removeClass( hiddenclass1 ); 
        }); 
      } 
  
  //Home (koha/mainpage.pl)
    //BEGIN hide "Checkout notes pending" if none are at this library 
      $('#main_intranet-main #checkout_notes_pending').addClass('hidden'); 
      if ($('#main_intranet-main').length) { 
        $.getJSON("/cgi-bin/koha/svc/report?id=3622&phase=Run+this+report&param_name=Enter+branchcode&sql_params=" + loglibbc + "&annotated=1", function(data) { 
          var hiddenclass2 = data[0].class; 
          var link2 = data[0].link; 
          $('#checkout_notes_pending').removeClass( hiddenclass2 ); 
          $('#main_intranet-main #area-pending').removeClass( hiddenclass2 ); 
          $('#checkout_notes_pending .pending-number-link').after().html(' | ' + link2 ); 
        }); 
      }
  
  //Home (koha/mainpage.pl)
    //BEGIN hide "Opac problem reports pending" if none are at this library 
      $('#main_intranet-main #problem_reports_pending').addClass('hidden'); 
      if ($('#main_intranet-main').length) { 
        $.getJSON("/cgi-bin/koha/svc/report?id=3623&phase=Run+this+report&param_name=Enter+branchcode&sql_params=" + loglibbc + "&annotated=1", function(data) { 
           var hiddenclass3 = data[0].class; 
           $('#problem_reports_pending').removeClass( hiddenclass3 ); 
           $('#main_intranet-main #area-pending').removeClass( hiddenclass3 ); 
         }); 
      }
  
  /* ========== END Put holds queue and alerts on the leftside of the home page ========== */ 
  
  //Home > Circulation > Checkouts > [BORROWERNAME (CARDNUMBER)] etc.
    //Only show "Files" patron option if logged in branch matches patron home branch
      if ($('body').is('[id^=pat_]') || $('body').is('#circ_circulation') || $('body').is('#tools_viewlog')) {
        if (borrower_home_library !== loglibname) {
        $('a:contains("Files")').parent().hide();
        }
      } 
  
  //Home > Catalog > {TITLE} > Place a hold 
    //BEGIN add staff information to notes when placing requests 
      $('#circ_request #hold-request-form button[type="submit"]').one("click", function() { 
        $("#holdnotes").val(function(index, val) { 
          return val + " - request placed by " + user_note; 
        }); 
      });  
  
//Home > Tools > LIBRARY_NAME calendar (/cgi-bin/koha/tools/holidays.pl) 
  //Libraries can only modify their own calendars (requires "shortloglibname" special function)
    $('#tools_holidays #branch option:not(:contains(' + shortloglibname + '))').hide(); 
    $('#tools_holidays #branchcode option:not(:contains(' + shortloglibname + '))').hide();
  //Disable and hide ability to copy holidays to all calendars 
    $('#tools_holidays #branchcode').attr('disabled', 'disabled'); 
    $('#tools_holidays #branchcode').parent().hide(); 
  //BEGIN make holiday title required 
    $('#tools_holidays #newHoliday #title').attr('required', 'true').after('<span class="required">Required</span>'); 
  //BEGIN add description with name and date to holidays (requires TIMESTAMP special function) 
    $(".cancel.hidePanel.newHoliday").prev().on("click", function() { 
      $("#newDescription").val(function(index, val) { 
        return val + " - closed date added by " + user_note; 
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


  //Home > Circulation > Checkouts > {BORROWERNAME} - (circ/circulation.pl?borrowernumber={borrowerid}) 
  //Home > Patrons > Patron details for {BORROWERNAME} - (/members/moremember.pl?borrowernumber={borrowerid}) 
    //make restriction comment required 
      $('#manual_restriction_form #rcomment').attr('required', 'required').attr('class', 'required'); 
    //add logedinusername and timestemp to restriction comment /* New */ 
      $('#manual_restriction_form input[value="Add restriction"]').one("click", function() { 
        $("#manual_restriction_form #rcomment").val(function(index, val) { 
          return val + " - manual restriction added by " + user_note;
        }); 
      }); 
  
  //Home > Patrons › Manual credit 
    //BEGIN Add automatic notes to manual credit 
      $("#mancredit > fieldset.action > input[type='submit']").one("click", function() { 
        $("#mancredit #note").val(function(index, val) { 
          return val + " - credit created by " + user_note; 
        }); 
      }); 
  
  //Home > Patrons › Manual invoice 
    //BEGIN Add automatic notes to manual invoice 
      $('#maninvoice fieldset.action > button:nth-child(1)').text('Save and go to "Transactions"'); 
      $('#maninvoice fieldset.action > button:nth-child(2)').text('Save and go to "Make a payment"'); 
      $("#maninvoice > fieldset.action > button[type='submit']").one("click", function() { 
        $("#pat_maninvoice #note").val(function(index, val) { 
          return val + " - invoice created by " + user_note; 
        }); 
      }); 
    
  //Patrons › Pay fines for PATRONNAME 
    //BEGIN Add automatic notes to payments and writeoffs 
      //Pay individual button 
        $("[name^=pay_indiv]").one("click", function() { 
          $("#finest [name^=payment_note]").val(function(index, val) { 
            return val + " - Paid/processed by " + user_note + " (pi)"; 
          }); 
        }); 
      //Write off individual 
        $("[name^=wo_indiv]").one("click", function() { 
          $("#finest [name^=payment_note]").val(function(index, val) { 
            return val + " - Written off/forgiven by " + user_note + " (wi)"; 
          }); 
        }); 
      //Write off all 
        $("#woall").one("click", function() { 
          $("#finest [name^=payment_note]").val(function(index, val) { 
            return val + " - Written off/forgiven by " + user_note + " (wa)"; 
          }); 
        }); 
      //Pay selected/pay all 
        $('#payfine :input[value="payment"], #payfine :input[value="PAYMENT"]').parent().addClass('paynote'); 
        $(".paynote .action > input:nth-child(1)").one("click", function() { 
          $("#selected_accts_notes").val(function(index, val) { 
            return val + " - Paid/processed by " + user_note + " (ps/pa)"; 
          }); 
        }); 
      //Write off selected 
        $('#payfine :input[value="WRITEOFF"]').parent().addClass('writeoffnote'); 
        $(".writeoffnote .action > input:nth-child(1)").one("click", function() { 
          $("#selected_accts_notes").val(function(index, val) { 
            return val + " - Written off/forgiven by " + user_note + " (ws)";
          }); 
        });
    
  //Home > Circulation > Checkouts > [BORROWERNAME (CARDNUMBER)]
  //Home > Patrons > [BORROWERNAME (CARDNUMBER)] > Details
    //Add automatic note to Claims Returned action
      $('#claims-returned-modal-btn-submit').click(function() { 
        $('#claims-returned-notes').val(function(index, val) { 
          return val + ' - Marked as "Claims returned" by ' + user_note; 
        }); 
      }); 
  
  //Home > Cataloging > Label creator > Layouts > New label layout 
    //Prepend branchcode to beginning of newly created label layouts, templates, and profiles
      if (url.indexOf("label-edit-layout.pl?op=new") != -1 | url.indexOf("label-edit-template.pl?op=new") != -1 |  url.indexOf("label-edit-profile.pl?op=new") != -1) { 
        $('.action > input:nth-child(1)').one("click", function() { 
          $('#layout_name').val(function(index, val) { 
            return loglibbc + " - " +  val; 
          }); 
          $('#template_code').val(function(index, val) { 
            return loglibbc + " - " +  val; 
          }); 
          $('#printer_name').val(function(index, val) { 
            return loglibbc + " - " +  val; 
          }); 
        }); 
      } 
    
  //Home > Patrons > Add patron ([BORROWERCATEGORY])
    //BEGIN rename fields "Surname" to "Last Name," "First Name" to "First/Middle Name," "Other Names" to "Nickname/Other name" 
      $("#memberentry_identity label[for='surname']").html("Last name:"); 
      $("#memberentry_identity label[for='middle_name']").html("Middle name /<br />middle initial:"); 
      $("#memberentry_identity label[for='othernames']").html("Nickname /<br />other name:"); 
    
  //Home 
    //Populate "High demand requests at your library" table 
      if ($('#area-userblock').length) { 
        var high_report_id = '3262'; 
        $.getJSON("/cgi-bin/koha/svc/report?id=" + high_report_id + "%26param_name=library1&sql_params=" + loglibbc + "&param_name=library2&sql_params=" + loglibbc, function(data1) { 
          $.each(data1, function(index, value) { 
            var json = value; 
            var tr; 
            tr = $('<tr/>'); 
            $.each(json, function(index, value) { 
              tr.append("<td>" + value + "</td>"); 
            }); 
            $('#localrequests_table').append(tr); // alert( index + ": " + value ); 
          }); 
        }); 
      } 
  
  //Home > Circulation > Checkouts > [BORROWERNAME]
    //BEGIN Add locked message to multiple patron pages if patron's login attempts is greater than 5 (requires corresponding css) 
      if ($('.patroninfo').length) { 
        $.getJSON("/cgi-bin/koha/svc/report?id=3187%26param_name=borrowernumber&sql_params=" + ($("input[name=borrowernumber]").val()) + "&annotated=1", function(data) { 
          var loginblocked = data[0].CLASS; 
          $('body').addClass(loginblocked); 
          $('.loginblock #toolbar').before('<div id="blockedpatron"><center><br /><br /><br /><h1>This account is locked due to more than five login attempts with an incorrect password.<br /><br />Use the "Change password" button to set a new password for the patron and unlock the account.</h1><br /><p><button id="blockedrep" type="button">Run locked status report for this patron</button></p><br /></center></div>'); 
          $('.loginblock #toolbar').after('<div id="dontedit" style="display: none;"><center><br /><h3>Using "Edit" to modify a password will not unlock the account.  Use "Change password" to unlock the account.</h3><br /></center></div>'); 
          $('#changepassword').wrapInner('<span id="cphighlight"></span>'); 
          $("#editpatron").hover( 
            function() { 
              $('#dontedit').show(); 
            }, 
            function() { 
              $('#dontedit').hide(); 
            } 
          ); 
          //opens report 3079 for this patron when button is clicked 
          var patronxid = $("input[name=borrowernumber]").val(); 
          $("#blockedrep").click(function() { 
            window.open('/cgi-bin/koha/reports/guided_reports.pl?reports=3163&phase=Run+this+report&sql_params=' + patronxid + ''); 
          }); 
        }); 
      } 
  
  
  //Home > Circulation > Checkouts > [BORROWERNAME]
    //BEGIN re-tool print and clear icon to do quick slip 
      $('#printclearscreen').hide(); 
      $('#clearscreen').prepend('<span style="position: absolute; right: 43px; top: 0;" id="qprintclearscreen"><a href="#" title="Print today\'s checkouts and clear screen"><i class="fa fa-print"></i></a></span>'); 
      $("#circ_circulation #qprintclearscreen").click(function() { 
        printx_window("qslip"); 
        window.location.replace("/cgi-bin/koha/circ/circulation.pl"); 
      });  
  
  //Home > Circulation > Checkouts > [BORROWERNAME]
    //BEGIN rename print drop-downs 
      $('#toolbar #printsummary').html('Full page-summary'); 
      $('#toolbar #printslip').html('Receipt-all checkouts'); 
      $('#toolbar #printquickslip').html("Receipt-today's checkouts"); 
  
  //Home > Circulation > Checkouts > [BORROWERNAME]
    //BEGIN blocks checkout to patron with "Expired" flag on their account 
      $(".patronattributelabel:contains('Account expiration')").addClass('label label-danger'); 
      $(".patronattributelabel:contains('Account expiration'), #pat_moremember #aai_EXPIRED").closest("body").addClass("expiredpatronx"); 
      $(".expiredpatronx #addchild, .expiredpatronx #changepassword, .expiredpatronx #duplicate, .expiredpatronx #searchtohold, .expiredpatronx .btn-group, .expiredpatronx a:contains('Renew'), .expiredpatronx #barcode, .expiredpatronx #menu a:contains(Batch check out)").hide(); 
      $('.expiredpatronx #barcode').parent().prepend("<p style='background: #FFFF00;font-size: 110%;font-weight: bold;'><br />This patron's account has been expired for a very long time and the account is scheduled to be automatically deleted.  The patron cannot check out items until the 'Account expiration' message has been removed.<br /><br />Click the 'EDIT' button; clear the 'Account expiration' message; then update the patron's contact information and click on 'Save.'  Then make sure their account has been renewed before proceeding.<br /> </p>"); 
      $("#aai_EXPIRED").css("background-color", "yellow"); 
  
    //Hides expired attribute if attribute is not already set 
      $("#aai_EXPIRED").hide(); 
      if($("#aai_EXPIRED select option:selected").val()!=0){ 
      $("#aai_EXPIRED").show(); 
      } 
  
    //BEGIN Changes messages back to HTML 
      $('#messages span').each(function() { 
        $(this).toHtml(); 
      }); 
  
  /*Sleepy time code*/
  
  //Special function
    //BEGIN creates sortMenus function - helps sort some non-sorted menus and dropdowns 
      function sortMenus (itembyID) { 
        $('#'+itembyID+'').html($('#'+itembyID+'').find('option').sort(function(x, y) { 
          return $(x).text() > $(y).text() ? 1 : -1; 
        })); 
      }
  
  if (url.indexOf('frameworkcode=FA') != -1) { 

  $('#cat_additem #additema').append('&nbsp;<button type="button" id="fast_magazine">Magazine</button>');
    
        $("#fast_magazine").click(function() { 
         $('[id*="tag_952_subfield_y_"]').val('P_MAG').change();
          
    });  

}
  

  
  //DO NOT DELETE ANYTHING BELOW THIS LINE 
  });
  
  /* Old stuff */
  $(document).ready(function () { 
  
  //Home > Cataloging > Edit TITLE > items (cataloguing/additem.pl?biblionumber=n)
    //Limit the number of copies that can be added to a biblio using the "Add multiple copies of this item" button
      $('#cat_additem #number_of_copies').attr('size','6').attr('type','number').attr('max','10');
    
    $('#hardduedate').val('');
    
    $('#patron_search #filters #searchfieldstype option[value="dateofbirth"]').remove();
    
    $('#pat_member .currentlibrary').addClass('badge btn-info');
  
   
      //ALL PAGES - Special functions 
        //Special function - TO_HTML 
  
        //Special function - SORT_DROPDOWN_MENUS 
          //BEGIN creates sortMenus function - helps sort some non-sorted menus and dropdowns 
           function sortMenus (itembyID) { 
            $('#'+itembyID+'').html($('#'+itembyID+'').find('option').sort(function(x, y) { 
              return $(x).text() > $(y).text() ? 1 : -1; 
            })); 
           } 
        //Special functions - create variables for multiple uses 
          //Special function BRANCHCODE 
            var loglibbc = $(".logged-in-branch-code").first().text().trim(); 
            $("body").addClass(loglibbc); 
          //Special function SHORTBRANCHCODE 
            var sloglibbc = $(".logged-in-branch-code").first().text().trim().substring(0, 4); 
          //Special function LIBNAME 
            var loglibname = $(".logged-in-branch-name:first").text().trim(); 
          //Special function SHORTNAME 
            var shortloglibname = $(".logged-in-branch-name:first").text().trim().substring(0, 5); 
            console.log(loglibbc, sloglibbc, loglibname, shortloglibname); 
        //Special function - TIMESTAMP 
          //BEGIN adds date in mm/dd/yyyy format to #todaysdate on every page in the system - very useful 
            var tsnow = new Date($.now()); 
            var tsday = ("0" + tsnow.getDate()).slice(-2); 
            var tsmonth = ("0" + (tsnow.getMonth() + 1)).slice(-2); 
            var tsyear = ("0" + (tsnow.getFullYear())).slice(-4); 
            var tshour = (tsnow.getHours()); 
            var tsminute = ("0" + tsnow.getMinutes()).slice(-2); 
            var prnow = (tsyear) + "." + (tsmonth) + "." + (tsday) + " - " + (tshour) + ":" + (tsminute); 
            $(".gradient").before("<span id='todaysdate' style='display: none;'>" + prnow + "</span>"); 
            console.log(prnow); 
   
      //ALL PAGES 
        //BEGIN open left side navbar drop-downs on hover 
          $(".navbar-nav li.dropdown:lt(3)").hover(function() { 
            $(this).addClass("open"); 
          }, function() { 
            $(this).removeClass("open"); 
          }); 
   
      //ALL PAGES 
        //BEGIN add individual library names to staff client /* new location */ 
          $('.gradient').append('<div id="branchpagehead" class="noprint" style="position: absolute; right: 0;"><h1>' + loglibname + '</h1></div>'); 
   
      //ALL PAGES 
        //BEGIN Fix searches by striping parenthesis and semicolons from links 
          $('a[href*="search.pl"]').attr('href', function(_, v) { 
            return v.replace(/(\w)(\(|\)|\;|\!)(\w)/g, '$1 $3'); 
          }).attr('href', function(_, v) { 
            return v.replace(/(\(|\)|\;|\!)/g, ''); 
          }); 
   
      //ALL PAGES 
        //Audio alerts hacks 
          //Buzz when "Enter" is typed instead of clicking 
            $('#wrong-transfer-modal .modal-footer, #item-transfer-modal .modal-footer, #hold-found2 .modal-footer').append('<button id="dropme" type="button" class="btn btn-default" style="display: inline; position: absolute; left: -999px">playsound</button><audio id=alarm><source src=https://raw.githubusercontent.com/northeast-kansas-library-system/next.training/master/source/sounds/transfer.ogg></audio>'); 
   
            $('#wrong-transfer-modal, #item-transfer-modal').on('shown.bs.modal', function () { 
              $('.approve').focus(); 
            }); 
   
            $('#hold-found2').on('shown.bs.modal', function () { 
              $('#dropme').focus(); 
            }); 
   
            $("#wrong-transfer-modal .approve, #item-transfer-modal .approve").keypress(function (event) { 
              event.preventDefault(); 
              if (event.which == 32) { 
                $(".approve").click(); 
              } else if (event.which == 13) { 
                document.getElementById('alarm').play(); 
                $('.modal-content').fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500); 
                $('.modal-content').attr('style', 'background-color: chartreuse; font-size: 200%'); 
              } 
            }); 
   
            $("#hold-found2 #dropme, #damageditemcheckin #damagedalarm").keypress(function (event) { 
              event.preventDefault(); 
              if (event.which == 32) { 
                document.getElementById('alarm').play(); 
              } else if (event.which == 13) { 
                document.getElementById('alarm').play(); 
                $('.modal-content').fadeOut(500).fadeIn(500).fadeOut(500).fadeIn(500); 
                $('.modal-content').attr('style', 'background-color: chartreuse'); 
                $('.modal-content h4').attr('style', 'font-size: 300%; background-color: chartreuse'); 
                $('.modal-content h4:contains("Notes:"), .modal-content li, .modal-content h5').hide(); 
              } 
            }); 
   
          //Adds classes to trigger audio alerts for lost, transfers, and requests 
            $('#circ_returns .problem:contains("Item is withdrawn.")').parent().parent().addClass('lostreturned'); 
            $('#circ_returns .problem:contains("Item was lost, now found.")').parent().parent().addClass('lostreturned'); 
            $('#circ_returns .approve:contains("Confirm hold and transfer")').parent().parent().addClass('transfer-alert'); 
            $('#circ_returns .approve:contains("Confirm hold")').parent().parent().addClass('hold-arrived'); 
   
        //END AUDIO ALERT HACKS 
   
      //Home > Reports > Guided  reports wizard > Saved reports 
        //Reveal these tables after tabs finished loading (see CSS) (v21.05) 
          $('#rep_guided_reports_start #tabs,#circ_circulation #patronlists,#acq_suggestion #suggestiontabs').css('display','block'); 
   
  
      //Home > Patrons (/cgi-bin/koha/members/members-home.pl) 
        //Hides "Staff - system login (exempt)" category from the "+New patron" button 
          $('#new-patron-button li:contains("system")').hide(); 
   
      //Home > Cataloging > Edit TITLE > Items (/cgi-bin/koha/cataloguing/additem.pl?biblionumber={biblionumber}) 
        //BEGIN Sort items by home library on default when table loads 
          $('#cat_additem #itemst').on('init.dt', function() { 
            $(this).dataTable().fnSort([$(this).find('tr[role=row] th:contains("Home library")').index('th'), 'asc']); 
          }); 
  
   
   
      //Home > Circulation > Check in (/cgi-bin/koha/circ/returns.pl) **
        //BEGIN add row count to table 
          $('#checkedintable tr:first').prepend('<th>Checkin row count</th>'); 
          $('#checkedintable tr:gt(0)').prepend('<td></td>'); 
          $('#checkedintable tbody tr').each(function(idx) { 
            $(this).children().first().html(idx + 1); 
          }); 
   
      //Home > Circulation > Check-in (/cgi-bin/koha/circ/returns.pl) 
        //Display a pop-up if an item has a damage status set (requires corresponding report) 
          if ($('#checkin-form').length) { 
            $.getJSON("/cgi-bin/koha/svc/report?id=3250%26param_name=Enter+item+barcode+number&sql_params=" + ($('.form-control-group input[name="ri-0"]').val()) + "&annotated=1", function(data) { 
              var damaged1 = data[0].DISPLAY; 
              var message1 = data[0].MESSAGE; 
              $('#checkin-form').before('<div id="damageditemcheckin" class="dialog alert lostreturned" style="display: ' + damaged1 + ' ' + message1 + '</div>'); 
            }); 
          } 
   
      //Home > Patrons > {firstname surname} ({cardnumber}) > Modify patron ({borrowercategory}) - (/members/memberentry.pl?op=modify&destination=circ&borrowernumber={borrowernumber}) 
      //Home > Patrons > Add patron ({borrowercategory}) - (/members/memberentry.pl?op=add&categorycode={categorycode}) 
        //Limit zip code to 5 digits 
          $('#pat_memberentrygen #zipcode, #pat_memberentrygen #B_zipcode, #pat_memberentrygen #altcontactzipcode').attr('maxlength', '5'); 
        //Add placeholder text to phone numbers 
          $('#phone, #phonepro, #B_phone, #altcontactphone').attr('placeholder', '999-999-9999'); 
   
      //Home > Circulation > Checkouts > {BORROWERNAME} - (circ/circulation.pl?borrowernumber={borrowerid}) 
      //Home > Patrons > Patron details for {BORROWERNAME} - (/members/moremember.pl?borrowernumber={borrowerid}) 
        //make restriction comment required 
          $('#manual_restriction_form #rcomment').attr('required', 'required').attr('class', 'required'); 
        //add logedinusername and timestemp to restriction comment /* New */ 
          $('#manual_restriction_form input[value="Add restriction"]').one("click", function() { 
            $("#manual_restriction_form #rcomment").val(function(index, val) { 
              return val + " - manual restriction added by " + ($(".loggedinusername").html().trim()) + " at " + ($(".logged-in-branch-code").html().trim() + " on " + ($('#todaysdate').html())); 
            }); 
          }); 
   
      //Patrons > Make a payment for {BORROWRNAME} - (members/pay.pl?borrowernumber={borrowernumber}) 
      //Patrons > Account for BORROWERNAME - (members/boraccount.pl?borrowernumber={borrowernumber}) 
        //Rename "Checkin date" column 
          $('#table_account_fines th:contains("Checkin date"), #finest th:contains("Checkin date")').text("Last status change"); 
   
      //Home > Catalog > {title} > Place a hold 
       //BEGIN Set newly placed holds in staff client to expire after one year if not filled 
        var url = $(location).attr('href'); 
        if (url.indexOf('request.pl') != -1) { 
          var holdtodate = new Date(); 
          var day = ("0" + holdtodate.getDate()).slice(-2); 
          var month = ("0" + (holdtodate.getMonth() + 1)).slice(-2); 
          var year = ("0" + (holdtodate.getFullYear() + 1)).slice(-4); 
          var holdtill = (year) + "-" + (month) + "-" + (day); 
          $('#circ_request #expiration_date').val(holdtill).attr('required','required'); 
          console.log("holdtill: " + holdtill);
        } 
   
      //Home 
        //Populate "High demand requests at your library" table 
          if ($('#area-userblock').length) { 
            var high_report_id = '3262'; 
            $.getJSON("/cgi-bin/koha/svc/report?id=" + high_report_id + "%26param_name=library1&sql_params=" + ($(".logged-in-branch-code").html().trim()) + "&param_name=library2&sql_params=" + ($(".logged-in-branch-code").html().trim()), function(data1) { 
              $.each(data1, function(index, value) { 
                var json = value; 
                var tr; 
                tr = $('<tr/>'); 
                $.each(json, function(index, value) { 
                  tr.append("<td>" + value + "</td>"); 
                }); 
                $('#localrequests_table').append(tr); // alert( index + ": " + value ); 
              }); 
            }); 
          } 
   
      //Home > Advanced search 
        //BEGIN add accelerated reader searches to advanced search 
          if ($('#catalog_advsearch').length) { 
            $("select.advsearch").append('<option value="arl,phr">Accelerated Reading Level</option>'); 
            $("select.advsearch").append('<option value="arp,phr">Accelerated Reading Point</option>'); 
          } 
   
      //Home > Reports > Guided reports wizard > Saved reports - (reports/guided_reports.pl?phase=Use saved) 
        //BEGIN Make "Run" button and all of the drop-up options on that button open report in new tab 
          $('#rep_guided_reports_start .btn-group.dropup, #rep_guided_reports_start .btn.btn-default.btn-xs').click(function() { 
            $('.dropdown-menu a, .btn-xs').attr('target', '_blank'); 
          }); 
   
      //Home > Catalog > {TITLE} > Place a hold 
        //BEGIN restrict staff's ability to modify a request 
          $('#circ_request a[title^="Move "], #circ_request a[title^="Toggle lowest"], #circ_request th:nth-child(10) img').hide(); 
          $('#circ_request input[name="reservedate"]').attr('readonly', 'readonly'); 
   
   
      //Home > Patrons > Make a payment for > {borrowername} ({borrowercardnumber}) 
        //Hide "Collected from patron:" and "Change to give:" drop-downs but also add a button to make their appearance optional 
          $('#pat_paycollect #change, #pat_paycollect #collected').parent().hide(); 
          $('#pat_paycollect #paid').parent().append("<li><label></label><button id='changecalc' type='button' class='btn btn-default' style='margin:10px 0px 0px 0px;'>Calculate change (optional)</button></li>"); 
          $("#changecalc").click(function() { 
            $("#changecalc").hide(); 
            $('#pat_paycollect #change, #pat_paycollect #collected').parent().show(); 
          }); 
        //Synchronize "Amount being paid" and "Amount collected" 
          $('#pat_paycollect #paid').keyup(function() { 
            $('#collected').val($('#paid').val()); 
          }); 
        //Rename "Payment type" 
          $("#pat_paycollect label[for='payment_type']").html("Payment type<br />(optional):"); 
   
   
      //HOME 
        //Populate upcoming closures table 
          if ($('#area-userblock').length) { 
            var closure_report_id = '3682'; 
            $.getJSON("/cgi-bin/koha/svc/report?id=" + closure_report_id + "&param_name=branchcode1&sql_params=" + loglibbc + "&param_name=branchcode2&sql_params=" + loglibbc + "&param_name=branchcode3&sql_params=" + loglibbc, function(data1) { 
              $.each(data1, function(index, value) { 
                var json = value; 
                var trx; 
                trx = $('<tr/>'); 
                $.each(json, function(index, value) { 
                  trx.append("<td>" + value + "</td>"); 
                }); 
                $('#closures_table').append(trx); // alert( index + ": " + value ); 
              }); 
            }); 
          } 
   
      //Home > Catalog > Details for {TITLE} 
        //BEGIN Redirect NoveList Select links to the staff client instead of the OPAC 
          $("#NovelistSelect").one("mouseenter", function(e) { 
            $("#NovelistSelect a").each(function() { 
              this.href = this.href.replace('/cgi-bin/koha/opac-search.pl', '/cgi-bin/koha/catalogue/search.pl'); 
            }); 
          }); 
   
      //Home > Administration > Patron categories > Modify category {CATEGORYNAME} 
        //Embiggen Library limitations 
          var av_category_size = $('#admin_categorie #branches').children().length; 
          $('#admin_categorie #branches').attr('size', av_category_size); 
   
      //Home > Administration > Libraries > Modify library 
        //BEGIN Branch input - relabel address line input 
          $("#admin_branches.admin label[for='branchaddress1']").html("Mailing address:"); 
          $("#admin_branches.admin label[for='branchaddress2']").html("Street address /<br />Physical address:"); 
          $("#admin_branches.admin label[for='branchaddress3']").html("Director / ILL contact:"); 
          $("#admin_branches.admin label[for='branchcountry']").html("KLE Code:"); 
   
      //Administration > Transportation cost matrix 
        //BEGIN Click on library name and row will move to the top of the table 
          $("#cost_matrix_form #transport-cost-matrix tr th:nth-child(1)").click(function() { 
            $(this).parent().insertAfter("#cost_matrix_form #transport-cost-matrix tbody tr:first"); 
          }); 
   
      //Home > Catalog > {TITLE} > Details 
        //BEGIN Make patron link in title details page go to "Circulation > Checkouts > -PATRONNAME-" instead of "Patrons > Patron details for -PATRONNAME-" 
          $('#catalog_detail .datedue a').each(function() { 
            this.href = this.href.replace('members/moremember.pl', 'circ/circulation.pl'); 
          }); 
   
      //Home > Catalog > {TITLE} > Details 
        //BEGIN Toggle "Show contents" 
          $('#catalog_detail .contentblock').hide(); 
          $('#catalog_detail span:contains("Contents")').html('<div class="contents_s" style="text-align: left; display: block;"><h2><ins>Click to show contents</ins></h2></div><div class="contents_h" style="text-align: left; display: none;"><h2>Click to hide contents</h2></div>'); 
          $('#catalog_detail .contentblock, .contents_s, .contents_h').click(function() { 
            $('#catalog_detail .contentblock, .contents_s, .contents_h').toggle(); 
          }); 
   
        //Add break between home library and shelving location 
          $('#catalog_detail .shelvingloc').prepend('<br />Shelving location:<br />'); 
   
        //Style "Recently returned" info 
          $('#catalog_detail .shelvingloc:contains("Recently returned")').each(function(){ 
            var content = $(this).html(); 
            content = content.replace('(Recently returned)','<br /><span class="recently_returned_badge badge btn-warning" style="color: black; font-size: 1.25em;"><i class="fa fa-exclamation-circle" style="color: white;"></i>&nbsp;Recently returned&nbsp;<i class="fa fa-exclamation-circle" style="color: white;"></i></span>'); 
            $(this).html(content); 
          }); 
   
        //Style "item level hold" info 
          $('#catalog_detail .holdonitem:contains("item level hold")').each(function(){ 
            var content = $(this).html(); 
            $(this).html('<span class="item_level_request_badge badge btn-warning" style="color: black; font-size: 1.25em;"><i class="fa fa-exclamation-circle" style="color: white;"></i>&nbsp;Item level request&nbsp;<i class="fa fa-exclamation-circle" style="color: white;"></i></span>'); 
          }); 
   
        //Style "Waiting" info 
          $('#catalog_detail .waitingat').each(function(){ 
            var content = $(this).html(); 
            content = content.replace('Waiting','<span class="waiting_at_badge badge btn-success" style="color: white; font-size: 1.2em;"><i class=" fa fa-clock-o" style="color: white;"></i>&nbsp;Waiting for pickup&nbsp;<i class="fa fa-clock-o" style="color: white;"></i></span><br /><br />'); 
            $(this).html(content); 
          }); 
   
        //Style "In transit" info 
          $('#catalog_detail .intransit').each(function(){ 
            var content = $(this).html(); 
            content = content.replace('In transit','<span class="waiting_at_badge badge btn-info" style="color: white; font-size: 1.2em;"><i class=" fa fa-truck" style="color: black;"></i>&nbsp;In transit&nbsp;<i class="fa fa-truck" style="color: black;"></i></span><br /><br />'); 
            $(this).html(content); 
          }); 
   
        //Style NFL, lost, damaged, and withdrawn statuses 
   
          $('.lost, .notforloan, .wdn').prepend('<i class="fa fa-ban"></i>&nbsp;').append('&nbsp;<i class="fa fa-ban"></i>').wrapInner('<span class="badge btn-danger" style="font-size: 1.2em; padding: 5px;"></span>').append('<br /><br />'); 
   
          $('.dmg').prepend('<i class="fa fa-exclamation-triangle"></i>&nbsp;').append('&nbsp;<i class="fa fa-exclamation-triangle"></i>').wrapInner('<span class="badge btn-secondary" style="font-size: 1.2em; padding: 5px"></span>').append('<br /><br />'); 
   
      //Home > Catalog > {TITLE} > Item details 
        //BEGIN Hide lost value 2 (Lost (more than 45 days overdue)) from item details screen 
          $('#catalog_moredetail .listgroup select[name="itemlost"] option[value="2"]').hide(); 
        //BEGIN hide paid for by and rename last borrower information 
          $('#catalog_moredetail .label:contains("Last returned by:")').addClass("lreturned"); 
          $('.lreturned').text('Last patron to have item:').attr('title', '"Last patron to have item" and "Last borrower" should be the same unless the most recent borrower has their checkout history disabled.'); 
          $('#catalog_moredetail .label:contains("Last borrower:")').parent().addClass("lborrower"); 
          $('.lborrower span').attr('title', '"Last borrower" and "Last patron to have item" should be the same unless the most recent borrower has their checkout history disabled.'); 
          $('#catalog_moredetail .label:contains("Previous borrower:")').parent().addClass("pborrower"); 
          $('.lborrower').next('.pborrower').addClass("2"); 
          $('.pborrower.2 .label').text('Previous borrower (2):'); 
          $('.pborrower.2').next('.pborrower').addClass("3"); 
          $('.pborrower.3 .label').text('Previous borrower (3):'); 
   
   
      //Home > Catalog > {TITLE} > Place a hold 
        //BEGIN Make patron link on this page go to "Circulation > Checkouts > -PATRONNAME-" instead of "Patrons > Patron details for -PATRONNAME-" 
          $('#circ_request a').each(function() { 
            this.href = this.href.replace('members/moremember.pl', 'circ/circulation.pl'); 
          }); 
   
      //BEGIN add staff information to notes when placing requests 
        $('#circ_request #hold-request-form button[type="submit"]').one("click", function() { 
          $("#holdnotes").val(function(index, val) { 
            return val + " - request placed by " + ($(".loggedinusername").html().trim()) + " at " + ($(".logged-in-branch-code").html().trim() + " on " + ($('#todaysdate').html())); 
          }); 
        }); 
   
      //Home > Catalog > {TITLE} > Place a hold 
        //BEGIN changes default item sort order to Home library 
          $('#requestspecific').on('init.dt', function() { 
            $(this).dataTable().fnSort([$(this).find('tr[role=row] th:contains("Home library")').index('th'), 'asc']); 
          }); 
   
      //Home Catalog Search  with limit(s): '(homebranch: "DIGITAL")' 
        //BEGIN Hoopla items unavailable > digital content 
          $('#bookbag_form > table > tbody > tr td .availability:contains("Digital Content")').addClass('digitalavailable'); 
          $('.digitalavailable .results_unavailable').each(function() { 
            var text = $(this).text(); 
            $(this).text(text.replace('1 unavailable', 'Digital content')); 
          }); 
          $('.digitalavailable .results_available_count').each(function() { 
            var text = $(this).text(); 
            $(this).text(text.replace('1 item, None available', 'Digital content')); 
          }); 
   
   
      //Home > Cataloging 
        //BEGIN Hide Z, DVD, and Online resource Frameworks 
          //$('#cat_addbooks li:contains("Default framework")').hide();
          //$('#cat_addbooks li:contains("Brief Records")').hide();
          $('#cat_addbooks li:contains("Digital assets")').hide();
          $('#cat_addbooks li:contains("DVD framework")').hide();
          //$('#cat_addbooks li:contains("Fast add for ILL or temporary circulation")').hide();
          //$('#cat_addbooks li:contains("Fast add for periodicals, magazines, and newspapers")').hide();
          $('#cat_addbooks li:contains("NEKLS story walk")').hide();
          $('#cat_addbooks li:contains("Online resource")').hide();
          $('#cat_addbooks li:contains("Realia")').hide();
          $('#cat_addbooks li:contains("Standard framework")').hide();
          $('#cat_addbooks li:contains("Y framework")').hide();
          $('#cat_addbooks li:contains("Z Framework")').hide();
   
        //BEGIN Hide merge button on cataloging search 
          $("#cat_addbooks .merge-items").hide(); 
   
      //Home Catalog Search for 'merge' 
        //Hide merge button with other dropdowns 
          $('#results_batch_ops').hide(); 
   
      //Home > Cataloging > Add MARC record 
      //Home > Cataloging > Editing {title} (Record number {biblionumber}) 
        //BEGIN CATHOVER_JQ highlight subfield row (requires CATHOVER_CSS) 
          $("#cat_addbiblio .subfield_line, #cat_addbiblio .tag, #cat_additem .subfield_line").hover( 
            function() { 
              $(this).addClass("cathover"); 
            }, 
            function() { 
              $(this).removeClass("cathover"); 
            } 
          ); 
   
      //Home > Cataloging > Add MARC record 
      //Home > Cataloging > Editing {title} (Record number {biblionumber}) 
        //BEGIN Add labels to Marc tabs 
          $(".toolbar-tabs-container a[href='#tab0XX']").append("<br />Control and coded fields"); 
          $("#tab0XX h3").append(" - Control and coded fields"); 
          $(".toolbar-tabs-container a[href='#tab1XX']").append("<br />Main entry"); 
          $("#tab1XX h3").append(" - Main entry"); 
          $(".toolbar-tabs-container a[href='#tab2XX']").append("<br />Title and edition"); 
          $("#tab2XX h3").append(" - Title and edition"); 
          $(".toolbar-tabs-container a[href='#tab3XX']").append("<br />Physical description"); 
          $("#tab3XX h3").append(" - Physical description"); 
          $(".toolbar-tabs-container a[href='#tab4XX']").append("<br />Series"); 
          $("#tab4XX h3").append(" - Series"); 
          $(".toolbar-tabs-container a[href='#tab5XX']").append("<br />Notes"); 
          $("#tab5XX h3").append(" - Notes"); 
          $(".toolbar-tabs-container a[href='#tab6XX']").append("<br />Subject access"); 
          $("#tab6XX h3").append(" - Subject access"); 
          $(".toolbar-tabs-container a[href='#tab7XX']").append("<br />Added and linking entry"); 
          $("#tab7XX h3").append(" - Added and linking entry"); 
          $(".toolbar-tabs-container a[href='#tab8XX']").append("<br />Series added entry<br />and electronic access"); 
          $("#tab8XX h3").append(" - Series added entry and electronic access"); 
          $(".toolbar-tabs-container a[href='#tab9XX']").append("<br />Koha related"); 
          $("#tab9XX h3").append(" - Koha related"); 
   
   
       //Cataloging > Edit {title} > Items 
         //BEGIN Hide lost value 2  (Lost (more than 45 days overdue)) and "Materials specified" on edit page 
           $("#subfield9521 select option[value='2']").remove(); 
         //$('#subfield9523').hide(); 
         //BEGIN add focus to search bar after adding an item 
           $("#cat_additem input[name=q]:eq(0)").focus(); 
   
  
   
      //Home > Cataloging > Editing {Title} (Record number {biblionumber}) > Items 
        //BEGIN reorganize and enchance add/edit item page 
          //add classes to additem.pl fields 
            $('#cat_additem span:contains("Withdrawn status")').parent().parent().parent().addClass('emb iastatus'); 
            $('#cat_additem span:contains("Lost status")').parent().parent().parent().addClass(' emb iastatus'); 
            $('#cat_additem span:contains("Materials specified")').parent().parent().parent().addClass('emb ianotes'); 
            $('#cat_additem span:contains("Damaged status")').parent().parent().parent().addClass('emb iastatus'); 
            $('#cat_additem span:contains("Not for loan")').parent().parent().parent().addClass('emb iastatus'); 
            $('#cat_additem span:contains("Collection")').parent().parent().parent().addClass('emb iaclass'); 
            $('#cat_additem span:contains("Home library")').parent().parent().parent().addClass('emb iaclass'); 
            $('#cat_additem span:contains("Current")').parent().parent().parent().addClass('emb iaclass'); 
            $('#cat_additem span:contains("Shelving location")').parent().parent().parent().addClass('emb iaclass'); 
            $('#cat_additem span:contains("Date acquired")').parent().parent().parent().addClass('emb iaq'); 
            $('#cat_additem span:contains("Source of acquisition")').parent().parent().parent().addClass('emb iaq'); 
            $('#cat_additem span:contains("Cost, normal purchase price")').parent().parent().parent().addClass('emb iaq'); 
            $('#cat_additem span:contains("call number")').parent().parent().parent().addClass('emb iaclass'); 
            $('#cat_additem span:contains("Barcode")').parent().parent().parent().addClass('emb iaclass'); 
            $('#cat_additem span:contains("Copy number")').parent().parent().parent().addClass('emb iaclass'); 
            $('#cat_additem span:contains("Cost, replacement price")').parent().parent().parent().addClass('emb iaq'); 
            $('#cat_additem span:contains("Non-public note")').parent().parent().parent().addClass('emb ianotes'); 
            $('#cat_additem span:contains("Item type")').parent().parent().parent().addClass('emb iaclass'); 
            $('#cat_additem span:contains("Public note")').parent().parent().parent().addClass('emb ianotes'); 
            $('#cat_additem span:contains("Koha date last seen")').parent().parent().parent().addClass('hidden'); 
          //add "emb" as a class to any elemet to increase its font size by 1.25em 
            $('.emb').attr('style', 'font-size: 1.25em;'); 
          //add headings/boxes 
            $('.iaclass').wrapAll('<fieldset id="classification" class="rows"><ol>'); 
            $('#classification ol').before('<legend style="font-size: 135%">Library, classification, and barcode</legend>'); 
            $('.iaq').wrapAll('<fieldset id="iaq" class="rows"><ol>'); 
            $('#iaq ol').before('<legend style="font-size: 135%">Acquisition data</legend>'); 
            $('.iastatus').wrapAll('<fieldset id="statuses" class="rows"><ol>'); 
            $('#statuses ol').before('<legend style="font-size: 135%">Item status</legend>'); 
            $('.ianotes').wrapAll('<fieldset id="ianotes" class="rows"><ol>'); 
            $('#ianotes ol').before('<legend style="font-size: 135%">Item notes</legend>'); 
   
      //Home > Cataloging > Z39.50/SRU pop-up 
        //BEGIN Resize Z39.50 window 
          if (document.location.href.indexOf('z3950_search.pl') > -1) window.moveTo(0, 0), window.resizeTo((screen.width * 0.9), (screen.height * 0.9)); 
          $(window).on('load resize', function() { 
            $('#cat_z3950_search .col-xs-6 .rows, #cat_z3950_search #z3950_search_targets').height($(this).height() * 0.75); 
            $('#cat_z3950_search .col-xs-6 .rows').css('overflow-y', 'scroll'); 
          }); 
  
   
      //Home > Circulation > Checkouts > {borrowername} ({borrowercardnumber}) 
        //Affects any pages where you can add a message to the patron's account 
        //BEGIN renames "note" to "message" where appropriate 
          $("#message_type option[value='L']").html("Staff - Internal message"); 
          $("#circ_circulation label[for='select_patron_messages']").html("Predefined messages: "); 
          $("#select_patron_messages option:contains(Select note)").html("Select message"); 
   
      //Home > Circulation > * 
        //BEGIN Remove Transfer, Set library, Fast cataloging, and Offline circulation links from left column and circulation sidebar 
          $('.circ-button[href="branchtransfers.pl"]').hide(); 
          $('.circ-button[href="/cgi-bin/koha/circ/set-library.pl"]').hide(); 
          $('.circ-button[href="/cgi-bin/koha/cataloguing/addbiblio.pl?frameworkcode=FA"]').hide(); 
          $('.circ-button[href="/cgi-bin/koha/circ/checkout-notes.pl"]').hide(); 
          $('.circ-button[href="/cgi-bin/koha/circ/pendingreserves.pl"]').hide(); 
          $('#offline-circulation ').hide(); 
          $('#navmenu #navmenulist h5:contains("Circulation")').parent().addClass('circsidebar'); 
          $('.circsidebar li:contains("Set library"), .circsidebar li:contains("Fast cataloging"), .circsidebar li:contains("Checkout notes"), .circsidebar li:contains("Holds to pull")').hide(); 
   
    //Home > Reports > Guided reports wizard > Saved reports > {REPORTNAME} ({REPORTID}) > Run 
      //BEGIN embiggen report notes and add yellow background only after they run (requires IntranetUserCSS css for #reportinfo styling) 
        var url_run = $(location).attr('href'); 
        if (url_run.indexOf('&phase=Run+this+report') != -1) { 
          $('.reportinfo').css({"background-color": "yellow", "fontSize": "122.5%"}); 
          $('.report_data_copy_btn').show();
        } 

  //Home > Patrons > Add patron ([borrowercategory]) (members/memberentry.pl?op=add&categorycode=)
    //Force Item due and Advance notice to auto-select "Digests only" when selected
   
      if (url.indexOf('memberentry.pl') != -1) { 
        
        var email1_var = document.getElementById('email1');
        var sms1_var = document.getElementById('sms1');
        var email2_var = document.getElementById('email2');
        var sms2_var = document.getElementById('sms2');
        
        $('#email1, #sms1').change(function() {
          if( (email1_var.checked == true) || (sms1_var.checked == true) ) {
            $('#digest1').prop('checked', 'true').delay('2000');
          }
        });
      
        $('#digest1').change(function() {
          if( (email1_var.checked == true) || (sms1_var.checked == true) ) {
            $('#digest1').prop('checked', 'true').delay('2000');
          }
        });
 
        $('#email2, #sms2').change(function() {
          if( (email2_var.checked == true) || (sms2_var.checked == true) ) {
            $('#digest2').prop('checked', 'true').delay('2000');
          }
        });
      
        $('#digest2').change(function() {
          if( (email2_var.checked == true) || (sms2_var.checked == true) ) {
            $('#digest2').prop('checked', 'true').delay('2000');
          }
        });

      } 

      /*==================== Unsorted - begins here ==========================*/ 
   
        //BEGIN redirect patron data to check-out instead of details 
        $("#circ_returns .ci-patron a").each(function() { 
          this.href = this.href.replace('members/moremember.pl', 'circ/circulation.pl'); 
        }); 
   
        //BEGIN Add patron name to "Hold found" modal 
        if ($('#hold-found2').length) { 
          $.getJSON("/cgi-bin/koha/svc/report?id=3186%26param_name=borrowernumber&sql_params=" + ($("#hold-found2 input[name=borrowernumber]").val()) + "&annotated=1", function(data) { 
            var zname = data[0].BORROWER_NAME; 
            $('#hold-found2 li span[class=patron-category]').parent().prepend(zname); 
          }); 
        } 
   
        //BEGIN Add KLE code to hold found modal 
        if ($('#hold-found2').length) { 
          $.getJSON("/cgi-bin/koha/svc/report?id=3194%26param_name=branchcode&sql_params=" + ($("#hold-found2 input[name=diffBranch]").val()) + "&annotated=1", function(data) { 
            var reqbrncode = data[0].SHIP_TO; 
            $('.modal-body > h4:nth-child(8)').append(reqbrncode); 
          }); 
        } 
   
        //BEGIN add KLE code to non-hold transfer modal 
        $(window).load(function() { 
          if ($("#circ_returns [id$=transfer-modal]").length) { 
            $.getJSON("/cgi-bin/koha/svc/report?id=3195%26param_name=branchname&sql_params=" + ($('[id$=transfer-modal] .modal-header h3:nth-child(1)').text().trim().substr(27)) + "&annotated=1", function(data) { 
              var ownbname = data[0].SHIP_TO; 
              $("[id$=transfer-modal] h3").append(ownbname); 
            }); 
          } 
        }); 
   
        //BEGIN Add KLE code to rotating collection modal 
        if ($('#rotating-collection').length) { 
          $.getJSON("/cgi-bin/koha/svc/report?id=3195%26param_name=branchname&sql_params=" + ($('#rotating-collection h3').text().trim().substr(25)) + "&annotated=1", function(data) { 
            var rotbrncode = data[0].SHIP_TO; 
            $('#rotating-collection h3').append(rotbrncode); 
          }); 
        } 
   
        //BEGIN "Patron note" modifications 
   
        //BEGIN adds ID to the patron note message 
        $("#circ_returns .dialog.message:contains('Patron note')").attr('id', 'ppnote'); 
   
        //BEGIN adds an ID to the last barcode number checked in and its home library (allows us to put these into the note later) 
        $("#circ_returns tr:nth-child(1) td:nth-child(5) a").attr('id', 'lastbcin'); 
        $("#circ_returns tr:nth-child(1) td:nth-child(6)").attr('id', 'lasthome'); 
        $("#circ_returns tr:nth-child(1) td:nth-child(11)").attr('id', 'lastpatron'); 
   
        //BEGIN removes focus from the barcode input 
        if ($("#ppnote").length) { 
          $("#barcode").blur(); 
        } 
   
        //BEGIN embiggens the title and the note and adds identifiers 
        $('#ppnote p:nth-of-type(2n)').wrapInner("<span style='font-size: 110%;'>Title: </span>"); 
        $('#ppnote p:nth-of-type(3n)').wrapInner("<span style='font-size: 110%; font-weight: bold;'>The patron says: </span>"); 
   
        //BEGIN adds the print button and the e-mail button 
        $('#ppnote').last('p').append('<br /><input type="button" id="problemprint" style="margin: 20px; padding: 5px;" value="Print this note">'); 
   
        //BEGIN adds the barcode number and the home library of the last checked in item to the note between the title and the patron's note 
        $(window).load(function() { 
          $('#ppnote p:nth-of-type(2n)').after("<p style='font-size: 110%;'>Item BC: <ins>" + $('#lastbcin').html() + "</ins></p>"); 
          $('#ppnote p:nth-of-type(3n)').after("<p style='font-size: 110%;'>Home library: <ins>" + $('#lasthome').html() + "</ins></p>"); 
        }); 
   
        //BEGIN adds function onto the print button 
        $("#problemprint").click(function() { 
          $("#barcode").focus(); 
          var divContents = $("#ppnote").html(); 
          var problemWindow = window.open('', '', 'height=500,width=500'); 
          problemWindow.document.write('<html><head><style>body {width: 260px; padding: 10px; word-wrap: break-word} input {display: none;}</style><title></title></head><body><div>'); 
          problemWindow.document.write(divContents); 
          problemWindow.document.write('<h1>Patron note</h1></div></body></html>'); 
          problemWindow.document.close(); 
   
          problemWindow.onload = function() { 
            problemWindow.focus(); 
            problemWindow.print(); 
            problemWindow.close(); 
          }; 
        }); 
   
      //END note 
   
       //Circulation > Checkouts > PATRONNAME 
        //BEGIN Adds color to "autoswitched" message 
        $('#autoswitched').attr('style', 'background: yellow'); 
   

   
        //BEGIN re-tool print and clear icon to do quick slip 
        $('#printclearscreen').hide(); 
        $('#clearscreen').prepend('<span style="position: absolute; right: 43px; top: 0;" id="qprintclearscreen"><a href="#" title="Print today\'s checkouts and clear screen"><i class="fa fa-print"></i></a></span>'); 
        $("#circ_circulation #qprintclearscreen").click(function() { 
          printx_window("qslip"); 
          window.location.replace("/cgi-bin/koha/circ/circulation.pl"); 
        }); 
   
        //BEGIN rename print drop-downs 
        $('#toolbar #printsummary').html('Full page-summary'); 
        $('#toolbar #printslip').html('Receipt-all checkouts'); 
        $('#toolbar #printquickslip').html("Receipt-today's checkouts"); 
   
        //BEGIN blocks checkout to patron with "Expired" flag on their account 
        $(".patronattributelabel:contains('Account expiration')").addClass('label label-danger'); 
        $(".patronattributelabel:contains('Account expiration'), #pat_moremember #aai_EXPIRED").closest("body").addClass("expiredpatronx"); 
        $(".expiredpatronx #addchild, .expiredpatronx #changepassword, .expiredpatronx #duplicate, .expiredpatronx #searchtohold, .expiredpatronx .btn-group, .expiredpatronx a:contains('Renew'), .expiredpatronx #barcode, .expiredpatronx #menu a:contains(Batch check out)").hide(); 
        $('.expiredpatronx #barcode').parent().prepend("<p style='background: #FFFF00;font-size: 110%;font-weight: bold;'><br />This patron's account has been expired for a very long time and the account is scheduled to be automatically deleted.  The patron cannot check out items until the 'Account expiration' message has been removed.<br /><br />Click the 'EDIT' button; clear the 'Account expiration' message; then update the patron's contact information and click on 'Save.'  Then make sure their account has been renewed before proceeding.<br /> </p>"); 
        $("#aai_EXPIRED").css("background-color", "yellow"); 
   
        //Hides expired attribute if attribute is not already set 
         $("#aai_EXPIRED").hide(); 
         if($("#aai_EXPIRED select option:selected").val()!=0){ 
          $("#aai_EXPIRED").show(); 
         } 
   
   
   
       $('.checkouts-by-itemtype').addClass('checkout-summary'); 
   
        //BEGIN Prevents unauthorized use of ILL cards 
        //LEAVENWORTH 
        $('#circ_circulation, #pat_moremember').each(function() { 
          if ($(".logged-in-branch-name:not(:contains(Leavenworth))", this).length && $(".patroninfo .patronlibrary:contains(Leavenworth)", this).length && $(".patroninfo .patroncategory:contains(ILL)", this).length) { 
            $('#barcode').hide(); 
            $('#menu a:contains(Batch check out)').hide(); 
            $('#toolbar').hide(); 
          } 
        }); 
   
        //OTTAWA 
        $('#circ_circulation, #pat_moremember').each(function() { 
          if ($(".logged-in-branch-name:not(:contains(Ottawa))", this).length && $(".patroninfo .patronlibrary:contains(Ottawa)", this).length && $(".patroninfo .patroncategory:contains(ILL)", this).length) { 
            $('#barcode').hide(); 
            $('#menu a:contains(Batch check out)').hide(); 
            $('#toolbar').hide(); 
          } 
        }); 
   
        //BEGIN Prevents unauthorized non-school use of school cards 
        //PHSD 
        $('#circ_circulation, #pat_moremember').each(function() { 
          if ($(".logged-in-branch-name:not(:contains(Prairie))", this).length && $(".patroninfo .patronlibrary:contains(Prairie)", this).length) { 
            $('#barcode').hide(); 
            $('#menu a:contains(Batch check out)').hide(); 
            $('#toolbar').hide(); 
            $('.patronlibrary').css('background', '#FFFF00'); 
            $('#barcode').parent().prepend("<p style='background: #FFFF00;font-size: 110%;font-weight: bold;'>Prairie Hills school district accounts can only be used to check out items at school.<br />If the patron wants to check out items at a public library,<br />they must get a public library card (if they do not already have one).</p>"); 
          } 
        }); 
   
        //BEGIN Prevents unauthorized use of 239500 
        //(also Circulation > Batch check out > PATRONNAME) 
        //(also Patrons > |*| for PATRONNAME) 
        $(".patroninfo:contains('239500')").attr('patronblock', 'block'); 
        if ($(".patroninfo").attr('patronblock')) { 
          $(".yui-g #mainform").prepend("<p><strong>This is not a patron account - it is a system account.</p><p>Please contact nexpresshelp@nekls.org for more information.</p>"); 
          $("#toolbar").hide(); 
          $("#circ_circulation_issue").hide(); 
          $("#messages.circmessage").hide(); 
          $(".action").hide(); 
          $("#menu").hide(); 
        } 
   
        //BEGIN re-label "Remember for session:" text 
        $("#circ_circulation label[for='stickyduedate']").html("Use this date until the browser is closed:"); 
   
        //BEGIN Make due date stand out (accompanying css highlights the whole box) 
        $('div.lastchecked > p:nth-child(1)').html(function(index, html) { 
          return html.replace('Due on', '<mark style="font-size: 18px;"><strong>Due on'); 
        }); 
        $('div.lastchecked > p:nth-child(1)').html(function(index, html) { 
          return html.replace('</p>', '</mark></strong></p>'); 
        }); 
   
        //BEGIN Rename Renew or check in button 
        $(":button:contains('Renew or check in selected items')").text("Renew checked items"); 
   
        //BEGIN Remove "Cancell all" button an accompanying text at top of screen 
        $("form[name='cancelAllReserve']").hide(); 
        $("#holdsover").contents().filter(function() { 
          return this.nodeType === 3; 
        }).wrap("<p style='display: none;'></p>"); 
   
        //Home 
   
        //Patrons › Manual credit 
        //BEGIN Add automatic notes to manual credit 
        $("#mancredit > fieldset.action > input[type='submit']").one("click", function() { 
          $("#mancredit #note").val(function(index, val) { 
            return val + " - credit created by " + ($(".loggedinusername").html().trim()) + " at " + ($(".logged-in-branch-code").html().trim() + " on " + ($('#todaysdate').html())); 
          }); 
        }); 
   
        //Patrons › Manual invoice 
        //BEGIN Add automatic notes to manual invoice 
        $('#maninvoice fieldset.action > button:nth-child(1)').text('Save and go to "Transactions"'); 
        $('#maninvoice fieldset.action > button:nth-child(2)').text('Save and go to "Make a payment"'); 
        $("#maninvoice > fieldset.action > button[type='submit']").one("click", function() { 
          $("#pat_maninvoice #note").val(function(index, val) { 
            return val + " - invoice created by " + ($(".loggedinusername").html().trim()) + " at " + ($(".logged-in-branch-code").html().trim() + " on " + ($('#todaysdate').html())); 
          }); 
        }); 
   
        //Patrons > BORROWERNAME > Modify patron 
        //BEGIN show collapsed fields that already have data in them and add (+) signs to all pre-collapsed fields 
        $(window).load(function() { 
          $('#memberentry_address ol:hidden').prev().append('<span> (+)</span>'); 
          $('#memberentry_address input').each(function() { 
            if ($('#memberentry_address input').val().length != 0) { 
              $('#memberentry_address ol').show(); 
            } 
          }); 
          $('#memberentry_altaddress ol:hidden').prev().append('<span> (+)</span>'); 
          $('#memberentry_altaddress input').each(function() { 
            if ($('#memberentry_altaddress input').val().length != 0) { 
              $('#memberentry_altaddress ol').show(); 
            } 
          }); 
          $('#memberentry_subscription ol:hidden').prev().append('<span> (+)</span>'); 
          $('#memberentry_subscription textarea').each(function() { 
            if ($('#memberentry_subscription textarea').val().length != 0) { 
              $('#memberentry_subscription ol').show(); 
            } 
          }); 
          $('#memberentry_account_flags ol:hidden').prev().append('<span> (+)</span>'); 
          if ($('#yesgonenoaddress').is(':checked') || $('#yeslost').is(':checked')) { 
            $('#memberentry_account_flags ol').show(); 
          } 
          $('#memberentry_restrictions table:hidden').prev().append('<span> (+)</span>'); 
          if ($('#memberentry_restrictions table').length != 0) { 
            $('#memberentry_restrictions, #manual_restriction_form').children().show(); 
          } 
          $('#patron_attributes_lgd').append('<span> (+)</span>'); 
        }); 
   
        //BEGIN turn "Show collapsed fields" checkbox into button 
        $('#pat_memberentrygen #toggle_hidden_fields').hide().after("<li><button id='borroweropen' type='button' style='margin: 5px'>Show collapsed fields</button>"); 
        //add event to new button 
        $("#borroweropen").click(function() { 
          $('#memberentry_guarantor').children().show(); 
          $('#memberentry_address ol').show(); 
          $('#memberentry_altaddress ol').show(); 
          $('#memberentry_subscription ol').show(); 
          $('#memberentry_account_flags ol').show(); 
          $('#memberentry_restrictions, #manual_restriction_form').children().show(); 
          $('#memberentry_patron_attributes').children().show().children().children().show(); 
   
   
        }); 
  
        //Main address / Alternate address / Alternate contact 
        //BEGIN Rename "Zip/Postal Code" to "Zip code" 
        $(".pat label[for='zipcode'], .pat label[for='altcontactzipcode'], .pat label[for='B_zipcode']").html("Zip code:"); 
   
        //BEGIN Move "School" attributes into the Main address block 
        $("#aai_School").insertBefore($("#memberentry_mainaddress label[for='address']").parent('li')); 
   
        //Contact 
        //BEGIN create clear e-mail buttons 
        $("#pat_memberentrygen #email").parents().eq(1).append("<li><label>Clear e-mail:</label><button id='clearprimeemail' type='button' style='margin: 5px'>Clear primary e-mail</button><button id='clearsecondemail' type='button' style='margin: 5px'>Clear secondary e-mail</button>"); 
        $("#clearprimeemail").click(function() { 
          $("#pat_memberentrygen #email").val("").focus(); 
        }); 
        $("#clearsecondemail").click(function() { 
          $("#pat_memberentrygen #emailpro").val("").focus(); 
        }); 
   
        //BEGIN Move "Holds contact" attributes to Contact box 
        $("#aai_Holdscon").insertBefore($("#memberentry_contact label[for='phone']").parent('li')); 
   
        //Library Management 
        //BEGIN Hide Louisburg and Digital from patron dropdown (Library management) 
        $("#pat_memberentrygen option[value='branch:LOUISBURG'], #pat_memberentrygen option[value='LOUISBURG']").hide(); 
        $("#pat_memberentrygen option[value='branch:DIGITAL'], #pat_memberentrygen option[value='DIGITAL']").hide(); 
   
        //BEGIN Move "Location" and "Permission" attributes into the Library management box 
        $("#aai_Location").insertBefore($("#memberentry_library_management label[for='sort1']").parent('li')); 
        $("#aai_Permissions").insertBefore($("#memberentry_library_management label[for='sort1']").parent('li')); 
        $("#aai_COLLECT").insertBefore($("#memberentry_library_management label[for='sort1']").parent('li')); 
        $("#aai_PREF").insertBefore($("#memberentry_library_management label[for='sort1']").parent('li')); 
   
        //OPAC/Staff login 
        //BEGIN Easy fill username options 
        $("#pat_memberentrygen #userid").parent().after('<li style="padding-top: 10px"><label>Username<br />options:</label><div class="btn-group ezfill" style="padding-top: 15px"><button class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="true">Username options <span class="caret"></span></button><ul class="dropdown-menu "><li><a id="clearid">Delete current username</a></li><li><a id="cardid">Use library card number for username</a></li><li><a id="nameid">Use firstname.lastname for username (Next default)</a></li></ul></div><p style="font-size: 125%;color: red;"><br />If a patron has been locked out of their account due to more than 5 failed login attempts, you can only remove the lockout through the <ins>"Change password"</ins> button on the checkout or patron details pages.<br />Assigning a new password here will not clear the lockout.</p>'); 
        $("#cardid").click(function() { 
          $("#entryform #userid").val($("#entryform #cardnumber").val()).focus(); 
        }); 
        $("#nameid").click(function() { 
          $("#entryform #userid").val($("#entryform #firstname").val().toLowerCase().replace(/[^a-zA-Z 0-9]+/g, "").replace(" ", "") + '.' + $("#entryform #surname").val().toLowerCase().replace(/[^a-zA-Z 0-9]+/g, "").replace(" ", "")).focus(); 
        }); 
        $("#clearid").click(function() { 
          $("#entryform #userid").val(""); 
        }); 
   
        //BEGIN Easy fill password buttons 
        $("#pat_memberentrygen #password2").parent().parent().append('<li><label>Password<br />options:</label><div class="btn-group ezfill"><button class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="true">Password options <span class="caret"></span></button><ul class="dropdown-menu "><li><a id="deletepass">Clear current password data</a></li><li><a id="lnamepass">Use last name for password (case sensitive)</a></li><li><a id="phonepass">Use last 4 digits of phone for password</a></li><li><a id="townpass">Use name of town in lowercase letters</a></li><li><a id="birthpass">Use birthdate in format MMDDYYYY (no / marks)</a></li></ul></div>'); 
        $("#phonepass").click(function() { 
          $("#entryform #password, #entryform #password2").val($("#entryform #phone").val().slice(-4)); 
        }); 
        $("#lnamepass").click(function() { 
          $("#entryform #password, #entryform #password2").val($("#entryform #surname").val()); 
        }); 
        $("#townpass").click(function() { 
          $("#entryform #password, #entryform #password2").val($("#entryform #city").val().toLowerCase()); 
        }); 
        $("#birthpass").click(function() { 
          $("#entryform #password, #entryform #password2").val($("#entryform #dateofbirth").val().replace(/\//g, '')); 
        }); 
        $("#deletepass").click(function() { 
          $("#entryform #password, #entryform #password2").val(""); 
        }); 
   
        //Patron messaging preferences 
        //BEGIN Easy fill messaging preferences 
        $("#patron_messaging_prefs_lgd").after("<p id='emailbuttons' style='margin: 5px'><button id='clearemail' type='button' style='margin: 5px'>Clear all email</button><button id='defaultemail' type='button' style='margin: 5px'>Reset e-mail defaults</button></p>"); 
        $("#clearemail").click(function() { 
          $("#email1, #email2, #digest1, #digest2, #email4, #email5, #email6").prop('checked', false); 
          $("#memberentry_messaging_prefs table select option[value=3]").attr("selected", "selected"); 
            if (sms1_var.checked == true) {
              $('#digest1').prop('checked','true');
            } else {
              $('#digest1').attr('disabled','disabled');
            }
            if (sms2_var.checked == true) {
              $('#digest2').prop('checked','true');
            } else {
              $('#digest2').attr('disabled','disabled');
            }
        }); 
        $("#defaultemail").click(function() { 
          
          $("#email1, #email2, #digest1, #digest2, #email4, #email5, #email6").prop('checked', false); 
          $("#email1, #email2, #email4, #email6").trigger('click'); 
          $('#digest1, #digest2').trigger('click').delay('2000');
          $("#memberentry_messaging_prefs table select option[value=3]").attr("selected", "selected"); 
        }); 
   
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
   
        //Moves SMS provider and number above the table 
        $('th:contains("Days in advance")').parents().eq(2).wrap('<div id="messagetable"></div>'); 
        $("#memberentry_messaging_prefs label:contains('SMS number:')").parent().wrap('<div id="smsnumbermove"></div>'); 
        $("#memberentry_messaging_prefs label:contains('SMS provider:')").parent().wrap('<div id="smsprovidermove"></div>'); 
        $("#smsnumbermove").prependTo("#messagetable").parent(); 
        $("#smsprovidermove").prependTo("#messagetable").parent(); 
   
        //BEGIN Rename SMS "Text messaging" for the sake of staff who don't know what SMS stands for 
        $('#memberentry_messaging_prefs label, #messagetable th').each(function() { 
          var text = $(this).text(); 
          $(this).text(text.replace('SMS', 'Text message')); 
        }); 
   
        //BEGIN add links to carrier lookup sites 
        $("#smsnumbermove").append("<div><p style='font-weight: bold; text-decoration: underline; color: red;'><br />'Advanced Notices' and 'Item Due' notices (e-mail and text) are sent between 2:00 and 2:30 a.m.<br />Patrons should set the 'Do Not Disturb' settings on their phone appropriately if they do not want their phones to alert them to these notices at that time of day.<br />Instructions for setting the do-not-disturb feature on most phones can be found at<br /><a href='https://www.imore.com/how-to-setup-use-do-not-disturb-iphone-ipad' target='_blank'>Set do-not-disturb for iPhone</a> | <a href='https://www.howtogeek.com/260225/androids-confusing-do-not-disturb-settings-explained/' target='_blank'>Set do-not-disturb for Android phones</a><br /><br />Charges for text messages may be incurred when using this service.<br/>Please have the patron check with their mobile service provider if they have questions about fees for text messages.</p><p style='font-weight: bold; text-decoration: underline;'><br /><a href='https://freecarrierlookup.com/' target='_blank'>Free Carrier Lookup - Click here to lookup a mobile phone provider (limited to 30 searches per month)</a><br /><a href='https://www.carrierlookup.com/' target='_blank'>Carrier Lookup - Click here to lookup a mobile phone provider</a><br /><a href='https://realphonevalidation.com/resources/phone-carrier-lookup/' target='_blank'>Phone Carrier Lookup - Click here to lookup a mobile phone provider</a><br /><a href='https://telnyx.com/number-lookup' target='_blank'>Telnyx - Click here to lookup a mobile phone provider</a><br /></p></div>").parent(); 
   
        $("#emailbuttons").append("<p id='smsbuttons' style='display: none;'><button id='clearsms' type='button' style='margin: 5px'>Clear all text</button> <button id='defaultsms' type='button' style='margin: 5px'>Default text messages</button>"); 
   
        $("#defaultsms").click(function() { 
          $("#sms1, #sms2, #sms4, #sms6, #digest1, #digest2").prop('checked', 'true'); 
          $('#digest1, #digest2').removeAttr('disabled');
          $("#memberentry_messaging_prefs table select option[value=3]").attr("selected", "selected"); 
        }); 
   
        $("#clearsms").click(function() { 
          $("#sms1, #sms2, #sms4, #sms5, #sms6, #digest1, #digest2").prop('checked', false);
          if (email1_var.checked == true) {
            $('#digest1').prop('checked','true');
          } else {
            $('#digest1').attr('disabled','disabled');
          }
          if (email2_var.checked == true) {
            $('#digest2').prop('checked','true');
          } else {
            $('#digest2').attr('disabled','disabled');
          }
        }); 
   
        //Patrons › PATRONNAME › Modify patron - Patron messaging preferences 
        $('#messagetable td:contains("Item check-in")').each(function() { 
          var text = $(this).text(); 
          $(this).text(text.replace('Item check-in', 'Email check-in receipt')); 
        }); 
        $('#messagetable td:contains("Item checkout")').each(function() { 
          var text = $(this).text(); 
          $(this).text(text.replace('Item checkout', 'Email check-out/renewal receipt')); 
        }); 
   
        //BEGIN adds registration library to field in additional attributes and identifiers 
        if (window.location.href.indexOf("cgi-bin/koha/members/memberentry.pl?op=add") > -1) { 
          $("li label:contains('Registration')").parent().attr("class", "reglibrary"); 
          $(".reglibrary textarea").attr("value", $(".logged-in-branch-name").html()); 
          $(".reglibrary a, .reglibrary textarea").hide(); 
        } 
   
        if ((window.location.href.indexOf("cgi-bin/koha/members/memberentry.pl?op=modify") > -1) || (window.location.href.indexOf("cgi-bin/koha/members/memberentry.pl?op=duplicate") > -1)) { 
          $("li label:contains('Registration')").parent().attr("class", "reglibrary"); 
          $(".reglibrary textarea").attr('readonly', true); 
          $(".reglibrary a").hide(); 
        } 
   
        //Patrons › Pay fines for PATRONNAME 
        //BEGIN Add automatic notes to payments and writeoffs 
        //Pay individual button 
        $("[name^=pay_indiv]").one("click", function() { 
          $("#finest [name^=payment_note]").val(function(index, val) { 
            return val + " - Paid/processed by " + ($(".loggedinusername").html().trim()) + " at " + ($(".logged-in-branch-code").html().trim()) + " (pi)" 
          }); 
        }); 
        //Write off individual 
        $("[name^=wo_indiv]").one("click", function() { 
          $("#finest [name^=payment_note]").val(function(index, val) { 
            return val + " - Written off/forgiven by " + ($(".loggedinusername").html().trim()) + " at " + ($(".logged-in-branch-code").html().trim()) + " (wi)" 
          }); 
        }); 
        //Write off all 
        $("#woall").one("click", function() { 
          $("#finest [name^=payment_note]").val(function(index, val) { 
            return val + " - Written off/forgiven by " + ($(".loggedinusername").html().trim()) + " at " + ($(".logged-in-branch-code").html().trim()) + " (wa)" 
          }); 
        }); 
        //Pay selected/pay all 
        $('#payfine :input[value="payment"], #payfine :input[value="PAYMENT"]').parent().addClass('paynote'); 
        $(".paynote .action > input:nth-child(1)").one("click", function() { 
          $("#selected_accts_notes").val(function(index, val) { 
            return val + " - Paid/processed by " + ($(".loggedinusername").html().trim()) + " at " + ($(".logged-in-branch-code").html().trim()) + " (ps/pa)" 
          }); 
        }); 
        //Write off selected 
        $('#payfine :input[value="WRITEOFF"]').parent().addClass('writeoffnote'); 
        $(".writeoffnote .action > input:nth-child(1)").one("click", function() { 
          $("#selected_accts_notes").val(function(index, val) { 
            return val + " - Written off/forgiven by " + ($(".loggedinusername").html().trim()) + " at " + ($(".logged-in-branch-code").html().trim()) + " (ws)" 
          }); 
        }); 
   
  
   
        //Patrons › Update patron records 
        //BEGIN Hide patron update notices from other branches (based on first 4 letters of the branch name) 
        $(window).load(function() { 
          var loglibnode = $(".logged-in-branch-name").text().trim().substring(0, 5); 
          $('#pending_updates h3 a:not(:contains("(' + loglibnode + '"))').parent().hide(); 
          $('#pending_updates a:not(:contains("(' + loglibnode + '"))').parent().next('.ui-accordion-content').hide(); 
        }); 
   
        //Reports › Guided reports wizard 
        //BEGIN adds date in mm/dd/yyyy format to #reportdate on the report start page 
        var now = new Date(); 
        var day = ("0" + now.getDate()).slice(-2); 
        var month = ("0" + (now.getMonth() + 1)).slice(-2); 
        var year = ("0" + (now.getFullYear())).slice(-4); 
        var now = (month) + "/" + (day) + "/" + (year); 
        $("#rep_guided_reports_start .gradient").before("<span id='todaysreport' style='display: none;'>" + now + "</span>"); 
   
   
   
        //Reports › Guided reports wizard › Saved reports 
        //BEGIN adds "ADMINREPORT" class to some reports 
        $('#table_reports td:contains("ADMINREPORT")').parent().addClass('adminreport'); 
   
        //BEGIN Hides "Delete selected" button on the bottom of the saved reports table 
        $("#reports_form > fieldset > input[type='submit']").hide(); 
   
        //BEGIN Hides "Duplicate" and "Schedule" option on action button 
        $("#table_reports a:contains('Duplicate')").hide(); 
        $("#table_reports a:contains('Schedule')").hide(); 
   
        //Reports › Guided reports wizard › Saved reports › -REPORTNAME- Report 
        //BEGIN Hides SQL output, adds toggle button for SQL and for report info 
        $("#rep_guided_reports_start .label:contains('Notes:')").parent().wrap("<div id='reportnotes'></div>"); 
        $(".report_heading_id ").after("<p> <button class='btn btn-small toggle_report_info noprint'> Toggle report info </button></p>"); 
        $("#rep_guided_reports_start .label:contains('Total number of results:')").parent().before("<p><button class='toggle_report_info noprint bottom-button'> Toggle report info </button></p>"); 
        $(".toggle_report_info").click(function(event) { 
          event.preventDefault(); 
          $(".reportinfo, .bottom-button").toggle("slow"); 
        }); 
   
        //Tools > Automatic item modifications by age 
        //BEGIN add Up/Down controls to re-order modification rules 
        $("#tools_automatic_item_modification_by_age #rules fieldset legend").each(function() { 
          $(this).prepend('<a class="moveup" href="#">- Up - </a>'); 
        }); 
        $(".moveup").click(function() { 
          $(this).closest("fieldset").insertBefore($(this).closest("fieldset").prev()); 
        }); 
   

        //Tools › Inventory 
        //BEGIN Set location filter to home library by default 
        $("#tools_inventory #inventory_form input[value='homebranch']").attr("checked", "checked"); 
   
        //BEGIN set default home library to logged in library 
        var invnode = $(".logged-in-branch-name").text().trim().substring(0, 5); 
        $('#tools_inventory #branchloop option:contains(' + invnode + ')').attr("selected", "selected"); 
   
        //Tools › Notices & slips 
        //BEGIN highlights notice row on hover 
        $("#tools_letter #lettert tr").hover( 
          function() { 
            $(this).addClass("highlighted-row"); 
          }, 
          function() { 
            $(this).removeClass("highlighted-row"); 
          }); 
   
        //BEGIN add focus to the name field when editing a notice 
        $("#tools_letter #add_notice li #name").focus(); 
   
        //Tools > Overdue notice/status triggers 
        //BEGIN highlights exempt and ILL patrons and adds class to rows 
        $('#tools_overduerules tr:not(:contains("exempt"))').addClass('nnorm'); 
        $('#tools_overduerules tr:contains("(exempt)")').css('color', 'red').addClass('nexempt'); 
        $('#tools_overduerules tr:contains("(exempt-ILL)")').css('color', 'blue').addClass('nill'); 
   
        //Tools › Stage MARC records for import 
        //BEGIN Add processing tips 
        $("#processfile li:contains('Template')").append('&nbsp;<span class="next_label_red">Change to "All incoming records"</span>');
        $("#processfile li:contains('Record matching rule')").append('&nbsp;<span class="next_label_red">Change to ISBN 020$a</span>'); 
        $("#processfile li:contains('Action if matching record found')").append('&nbsp;<span class="next_label_red">Change to Ignore Incoming</span>'); 
        $("#processfile li:contains('Action if no match is found')").append('&nbsp;<span class="next_label_red">Change to Add Incoming</span>'); 
        $("#processfile li:contains('How to process items')").append('&nbsp;<span class="next_label_red">Change to Add Items only if matching bib was found</span>'); 
   
        //BEGIN SCHOOL 
        //BEGIN redirect school holds to nearest public library during the summer 
          /*$("#pickup option[value='PHAXTELL']").attr("value","SENECA").html('Prairie Hills - Axtell: Closed for the summer - Items will route to Seneca Free Library'); 
          $("#pickup option[value='PHSES']").attr("value","SABETHA").html('Prairie Hills - Sabetha Elementary Closed for the summer - Items will route to Sabetha: Mary Cotton Library'); 
          $("#pickup option[value='PHSHS']").attr("value","SABETHA").html('Prairie Hills - Sabetha High Closed for the summer - Items will route to Sabetha: Mary Cotton Library'); 
          $("#pickup option[value='PHSMS']").attr("value","SABETHA").html('Prairie Hills - Sabetha Middle Closed for the summer - Items will route to Sabetha: Mary Cotton Library'); 
          $("#pickup option[value='PHWAC']").attr("value","WETMORE").html('Prairie Hills - Wetmore: Closed for the summer - Items will route to Wetmore Community Library');*/ 
   
        //BEGIN Add features for superusers 
        $(".loggedinusername:contains('admin')").attr('neklssuperduperuser', 'yes'); 
        $(".loggedinusername:contains('nekls')").attr('neklssuperduperuser', 'yes'); 
        $(".loggedinusername:contains('mmcdonald')").attr('neklssuperduperuser', 'yes'); 
        $(".loggedinusername:contains('robin.hastings')").attr('neklssuperduperuser', 'yes'); 
        $(".loggedinusername:contains('SEKLSLOGIN')").attr('neklssuperduperuser', 'yes'); 
        $(".loggedinusername:contains('bywater')").attr('neklssuperduperuser', 'yes'); 
        $(".loggedinusername:contains('dan.alexander')").attr('neklssuperduperuser', 'yes'); 
        $(".loggedinusername:contains('gwilliams')").attr('neklssuperduperuser', 'yes'); 
        $(".loggedinusername:contains('kylemhall')").attr('neklssuperduperuser', 'yes'); 
        $(".loggedinusername:contains('ghwtest')").attr('neklssuperduperuser', 'yes'); 
        $(".loggedinusername:contains('greg.gantz')").attr('neklssuperduperuser', 'yes'); 
        $(".loggedinusername:contains('bwssupport')").attr('neklssuperduperuser', 'yes'); 
        $(".loggedinusername:contains('NEXTBRAND')").attr('neklssuperduperuser', 'yes'); 
        if ($(".loggedinusername").attr('neklssuperduperuser')) { 
   
          //Allow merge patrons 
          $('#merge-patrons').show(); 
   
          //Allow superusers to access catalogging editor 
          //$("#switcheditor").show(); 
   
          //Show "Super Librarian" on gradient to identify super users 
          $('#branchpagehead h1').append('<i class="fa fa-bolt fa-fw" title="Superlibrarian patron"></i>'); 
          $('#branchpagehead h1').prepend('<i class="fa fa-bolt fa-fw" title="Superlibrarian patron"></i>'); 
   
          //Allow superusers to back-date requests 
          //$('#hold-request-form #reserve_date').attr('data-flatpickr-futuredate','false'); 
   
          //Allow superusers access to restricted catalogging tools 
          $('#batchedit').show(); 
          $('#batchdelete').show(); 
          $('#deleteallitems').show(); 
          $('#batchedit-disabled').show(); 
          $('#batchdelete-disabled').show(); 
          $('#deleteallitems-disabled').show(); 
          $("#cat_addbooks li:contains('Z Framework')").show(); 
          $("#cat_addbooks li:contains('DVD framework')").show(); 
          $("#cat_addbooks li:contains('Online resource')").show(); 
   
          //Add button to show all pending patron updates 
          $('#pat_update h2:contains(Update patron records)').parent().prepend("<button id='pudshow' type='button'>Show all pending updates</button>"); 
          $("#pudshow").click(function() { 
            $("#pudshow").hide(); 
            $('#pending_updates h3 a:not(:contains("(' + loglibnode + '"))').parent().show(); 
            $('#pending_updates .ui-accordion-content:first').show(); 
          }); 
   
          //Tools > News 
          //BEGIN Enable News features for superlibrarians 
          $("#tools_koha-news fieldset.rows > ol").prepend("<button id='newsshow' type='button' style='margin: 10px;'>Release limits</button>"); 
          $("#newsshow").click(function() { 
            $("#newsshow").fadeOut(); 
            $('#tools_koha-news option').show(); 
            $('#tools_koha-news option').removeAttr("disabled"); 
            $("#tools_koha-news .yui-t7 #branch option:contains('All libraries')").attr("selected", "selected"); 
          }); 
   
          //Tools > LIBRARY NAME Calendar 
          $("#tools_holidays #branch").after("<button id='calshow' type='button' style='margin: 10px;'>Choose any branch</button>"); 
          $("#calshow").click(function() { 
            $("#calshow").fadeOut(); 
            $('#tools_holidays option').show(); 
          }); 
   
          //BEGIN Show "Duplicate" and "Schedule" option on action button 
          $("#table_reports a:contains('Duplicate')").show(); 
          $("#table_reports a:contains('Schedule')").show(); 
   
          //GHW - movie type select 
          $('#searchterms').after("<button id='movselectx' type='button'  style='margin: 5px'>Select all video types</button>"); 
          $("#movselectx").click(function() { 
            $("#catalog_advsearch [value*='NVID']").attr("checked", "checked"); 
          }); 
   
          //GHW - load all reports in descending order 
          $('#table_reports').on("init.dt", function() { 
            var table = $('#table_reports').DataTable(); 
            table.page.len(-1); 
            table.order([1, "desc"]); 
            table.draw(); 
          }); 
   
          //Reports > Guided reports wizard > Saved reports 
          $('#rep_guided_reports_start #tabs').before("<button id='showallreports' type='button' class='btn btn-default btn-sm' style='margin: 5px'>Show hidden reports</button>"); 
          $("#showallreports").click(function() { 
            $(".adminreport").show(); 
            $('#showallreports').hide(); 
          }); 
   
          //BEGIN Onetime 
   
          //END Onetime 
   
        } 
   
        $('#catalog_detail #batchedit').attr('disabled', 'disabled'); 
   
        //BEGIN push local library to top of virtual holds queue and collapse remote queues 
        var holdsnode = $(".logged-in-branch-name").text().trim().substring(0, 5); 
        $('#circ_request form fieldset legend:contains(' + holdsnode + ')').parent().addClass('localqueue'); 
        $('#circ_request form fieldset legend:not(:contains(' + holdsnode + '))').parent().addClass('remotequeue'); 
        $('.localqueue').insertAfter('#circ_request #existing_holds #toolbar'); 
        $(".remotequeue legend").each(function() { 
          $(this).append("<span class='rcloser' style='display: none;'> (+)</span><span class='rcloser'> (-)</span>"); 
          $(this).wrapInner("<a class='viewRSwitch' />"); 
          $(this).parent().children().not("legend").wrap("<div class='contentsRToggle' />"); 
          $("#memberentry_patron_attributes div:first").removeAttr('class'); 
          $('.contentsRToggle').hide(); 
        }); 
   
        //Triggers the click element 
        $(".viewRSwitch").click(function() { 
          $(this).find(".rcloser").toggle(); 
          $(this).parent().parent().children(".contentsRToggle").toggle("slow"); 
        }); 
   
        //BEGIN Create button to toggle all queues 
        $(".remotequeue").last().after("<fieldset><button id='remshowall' type='button' style='margin: 5px; display: block;'>Show all other queuess</button><button id='remhideall' type='button' style='margin: 5px; display: none;'>Hide all other queuess</button></fieldset>"); 
        $("#remshowall").click(function() { 
          $('.contentsRToggle').show("slow"); 
          $('#remshowall').hide(); 
          $('#remhideall').show(); 
        }); 
        $("#remhideall").click(function() { 
          $('.contentsRToggle').hide("slow"); 
          $('#remhideall').hide(); 
          $('#remshowall').show(); 
        }); 
   
        $('.NEKLS #remshowall').each(function() { 
          $(this).click(); 
          $('.request_reserve_date input').removeAttr('readonly'); 
        }); 
   
        //Tools > Batch patron modification 
        //BEGIN sort patron lists in batch modification tool 
        $("#patron_list_id").one("click", function() { 
          var selisted = $('#patron_list_id:selected').val(); 
          $("#patron_list_id").html($('#patron_list_id option').sort(function(x, y) { 
            return $(x).text().toUpperCase() < $(y).text().toUpperCase() ? -1 : 1; 
          })); 
          $("#patron_list_id").val(selisted); 
        }); 
   
        //BEGIN sort attribute drop-down in the batch modification tool 
        $(function() { 
          var select = $('.attributes > label:nth-child(1) > select:nth-child(1)'); 
          select.html(select.find('option').sort(function(x, y) { 
            return $(x).text() > $(y).text() ? 1 : -1; 
          })); 
          $('.attributes > label:nth-child(1) > select:nth-child(1) > option:nth-child(1)').attr('selected', true); 
        }); 
   
      //BASEHOR specific 
       //Adds class to KANOPY allowed attribute 
       $('.BASEHOR label:contains("Kanopy (BASEHOR):")').parent().addClass('BASEHORkanopy'); 
       //Adds Kanopy allowed value to new patrons created at LEAVENWRTH only on new users 
       var url = $(location).attr('href'); 
       if (url.indexOf("memberentry.pl?op=add") != -1) { 
         $('.BASEHORkanopy select option[value=BASEHOR]').attr("selected", "selected"); 
       } 
       //Changes to Kanopy not allowed when home library is changed to not-BASEHOR 
       $('.BASEHOR #libraries').change(function() { 
         $('.BASEHORkanopy select option[value="0"]').attr("selected", "selected"); 
       }); 
       //Changes to Kanopy allowed when home library is changed to BASEHOR 
       $('.BASEHOR #libraries option[value=BASEHOR]').click(function() { 
         $('.BASEHORkanopy select option[value=BASEHOR]').attr("selected", "selected"); 
       }); 
   
       //LANSING specific 
        //Adds class to KANOPY allowed attribute 
        $('.LANSING label:contains("Kanopy (LANSING):")').parent().addClass('lansingkanopy'); 
        //Adds Kanopy allowed value to new patrons created at LEAVENWRTH only on new users 
        var url = $(location).attr('href'); 
        if (url.indexOf("memberentry.pl?op=add") != -1) { 
          $('.lansingkanopy select option[value=LANSING]').attr("selected", "selected"); 
        } 
        //Changes to Kanopy not allowed when home library is changed to not-LANSING 
        $('.LANSING #libraries').change(function() { 
          $('.lansingkanopy select option[value="0"]').attr("selected", "selected"); 
        }); 
        //Changes to Kanopy allowed when home library is changed to LANSING 
        $('.LANSING #libraries option[value=LANSING]').click(function() { 
          $('.lansingkanopy select option[value=LANSING]').attr("selected", "selected"); 
        }); 
   
       //LEAVENWRTH specific 
        //Adds class to KANOPY allowed attribute 
        $('.LEAVENWRTH label:contains("Kanopy (LEAVENWRTH):")').parent().addClass('leavenwrthkanopy'); 
        //Adds Kanopy allowed value to new patrons created at LEAVENWRTH only on new users 
        var url = $(location).attr('href'); 
        if (url.indexOf("memberentry.pl?op=add") != -1) { 
          $('.leavenwrthkanopy select option[value=LEAVENWRTH]').attr("selected", "selected"); 
        } 
        //Changes to Kanopy not allowed when home library is changed to not-LEAVENWRTH 
        $('.LEAVENWRTH #libraries').change(function() { 
          $('.leavenwrthkanopy select option[value="0"]').attr("selected", "selected"); 
        }); 
        //Changes to Kanopy allowed when home library is changed to LEAVENWRTH 
        $('.LEAVENWRTH #libraries option[value=LEAVENWRTH]').click(function() { 
          $('.leavenwrthkanopy select option[value=LEAVENWRTH]').attr("selected", "selected"); 
        }); 
   
        //LINWOOD specific 
        //Adds class to KANOPY allowed attribute 
        $('.LINWOOD label:contains("Kanopy (LINWOOD):")').parent().addClass('linwoodkanopy'); 
        //Adds Kanopy allowed value to new patrons created at LINWOOD only on new users 
        var url = $(location).attr('href'); 
        if (url.indexOf("memberentry.pl?op=add") != -1) { 
          $('.linwoodkanopy select option[value=LINWOOD]').attr("selected", "selected"); 
        } 
        //Changes to Kanopy not allowed when home library is changed to not-LINWOOD 
        $('.LINWOOD #libraries').change(function() { 
          $('.linwoodkanopy select option[value="0"]').attr("selected", "selected"); 
        }); 
        //Changes to Kanopy allowed when home library is changed to LINWOOD 
        $('.LINWOOD #libraries option[value=LINWOOD]').click(function() { 
          $('.linwoodkanopy select option[value=LINWOOD]').attr("selected", "selected"); 
        }); 
   
        //BONNERSPGS specific 
          //Adds class to KANOPY allowed attribute 
          $('.BONNERSPGS label:contains("Kanopy (BONNERSPGS):")').parent().addClass('bonnerspgskanopy'); 
          //Adds Kanopy allowed value to new patrons created at BONNERSPGS only on new users 
          var url = $(location).attr('href'); 
          if (url.indexOf("memberentry.pl?op=add") != -1) { 
            $('.bonnerspgskanopy select option[value=BONNERSPGS]').attr("selected", "selected"); 
          } 
          //Changes to Kanopy not allowed when home library is changed to not-BONNERSPGS 
          $('.BONNERSPGS #libraries').change(function() { 
            $('.bonnerspgskanopy select option[value="0"]').attr("selected", "selected"); 
          }); 
          //Changes to Kanopy allowed when home library is changed to BONNERSPGS 
          $('.BONNERSPGS #libraries option[value=BONNERSPGS]').click(function() { 
            $('.bonnerspgskanopy select option[value=BONNERSPGS]').attr("selected", "selected"); 
          }); 
   
        //SABETHA specific 
        //Adds class to KANOPY allowed attribute 
        $('.SABETHA label:contains("Kanopy (SABETHA):")').parent().addClass('sabethakanopy'); 
        //Adds Kanopy allowed value to new patrons created at SABETHA only on new users 
        var url = $(location).attr('href'); 
        if (url.indexOf("memberentry.pl?op=add") != -1) { 
          $('.sabethakanopy select option[value=SABETHA]').attr("selected", "selected"); 
        } 
        //Changes to Kanopy not allowed when home library is changed to not-SABETHA 
        $('.SABETHA #libraries').change(function() { 
          $('.sabethakanopy select option[value="0"]').attr("selected", "selected"); 
        }); 
        //Changes to Kanopy allowed when home library is changed to SABETHA 
        $('.SABETHA #libraries option[value=SABETHA]').click(function() { 
          $('.sabethakanopy select option[value=SABETHA]').attr("selected", "selected"); 
        }); 
   
        //REPORTS - makes notes field full height 
        $("#rep_guided_reports_start #notes").attr('class', 'sqlnotes'); 
        $('.sqlnotes').on('click keyup', function() { 
          $('.sqlnotes').css('height', 'auto'); 
          $('.sqlnotes').height(this.scrollHeight); 
          $('.sqlnotes').css('overflow-y', 'hidden;'); 
        }); 
   
        //BEGIN prevents printing non-report parts of a reports results page 
        $('#rep_guided_reports_start .col-sm-2.col-sm-pull-10, #rep_guided_reports_start .navbar, #rep_guided_reports_start .gradient, #rep_guided_reports_start #breadcrumbs, #rep_guided_reports_start .gradient, #rep_guided_reports_start #newlogo, .gradient li').addClass('noprint'); 
   
        //Checkin - fixes problematic "refund has been applied" text 
        $('.problem:contains("refund has been")').each(function() { 
          var text = $(this).text(); 
          $(this).text(text.replace("has been applied to the borrowing", "may have been applied to the last")); 
        }); 
   
        //BEGIN set default messaging preferences when adding guarantor 
        var urx = $(location).attr('href'); 
        if (urx.indexOf("memberentry.pl?op=add&guarantor") != -1) { 
          $('#email1, #email2, #email4, #email6, #digest1, #digest2').attr('checked', 'checked'); 
          $('select[name$="2-DAYS"] option[value="3"]').attr('selected', 'selected'); 
        } 
   
        //Causes 856 links to open in new window 
        $("#catalogue_detail_biblio .results_summary.online_resources a").attr('target', '_blank'); 
   
        $('#pat #state').on('keydown', function(e) { 
          var charCode = e.key.charCodeAt(0); 
          if (!((charCode >= 0x30 && charCode <= 0x39) || (charCode >= 0x41 && charCode <= 0x7a))) { 
            e.preventDefault(); 
          } 
        }); 
   
        $('#pat_memberentrygen #state, #pat_memberentrygen #altcontactstate, #pat_memberentrygen #B_state, #pat_memberentrygen #cardnumber').on('keyup', function(e) { 
          $(this).val($(this).val().toUpperCase()); 
        }); 
   
        $('#pat_memberentrygen #saverecord').hover(function() { 
          $("input, textarea").val((i, v) => v.replace(/\s{2,}/g, ' ')); 
          $('[id^="add"], [id^="B_add"], [id^="B_add"]').val((i, v) => v.replace(/[.,\+\!$%\^&\*;:{}=_`~@<>]/g, '')); 
        }); 
   
        $("#pat_memberentrygen #state").parent().append("<span class='required longstate' style='display: none; font-weight: bold;'>State names should be abbreviated following USPS guidelines at <a href='https://pe.usps.com/text/pub28/28apb.htm' target='_blank'>this link</a></span>"); 
        $("#pat_memberentrygen #state").keyup(function() { 
          if ($(this).val().length > 2) { 
            $('.longstate').show(); 
            $('#state').addClass('alert'); 
          } else if ($(this).val().length < 3) { 
            $('.longstate').hide(); 
            $('#state').removeClass('alert'); 
          } 
        }); 
   
        $('#pat_memberentrygen #phone, #pat_memberentrygen #borrower_phonepro').after("<span class='required shortphone' style='display: none; font-weight: bold;'>Phone numbers should start with a phone number in the format 999-999-9999 or start with 'No phone' or 'Disconnected'</span>"); 
        $('#pat_memberentrygen #phone, #pat_memberentrygen #borrower_phonepro').keyup(function() { 
          var phone = $('#pat_memberentrygen #phone, #pat_memberentrygen #borrower_phonepro').val(); 
          var phoneReg = /^([2-9][0-9]{2}-[0-9]{3}-[0-9]{4}|No phone|No phone|Disconnected|^$)+.*$/; 
          if (!phoneReg.test(phone)) { 
            $('.shortphone').show(); 
            $('#pat_memberentrygen #phone, #pat_memberentrygen #borrower_phonepro').addClass('alert'); 
          } else if (phoneReg.test(phone)) { 
            $('.shortphone').hide(); 
            $('#pat_memberentrygen #phone, #pat_memberentrygen #borrower_phonepro').removeClass('alert'); 
          } 
        }); 
   
   
   
        $('#transport-cost-matrix').click(function() { 
          $('#transport-cost-matrix .enable_cost_input').click(); 
        }); 
   
        $('#transport-cost-matrix tr').click(function() { 
          $('#transport-cost-matrix .disable_transport_cost').attr("checked", "false"); 
        }); 
   
        $('#pat_memberentrygen span:contains("AutoMemberNum is set to enabled")').hide(); 
   
        $('#set-automatic-renewal').hide(); 
        $('#auto_renew').prop('disabled', true); 
   
   
        $('#circ_circulation #specify-due-date #cleardate').after('<br /><h3>If you need to modify a due date,<br />use these controls to set a new due date <span style="font-style: italic; text-decoration: underline;">before</span> you scan an item barcode.</h3>'); 
   
        $("#tools_batch_extend_due_dates #branchcodes").attr('size', '53'); 
   
        $("#tools_batch_extend_due_dates #categorycodes").attr('size', '20'); 
   
        $(".checkme").click(function() { 
          $(".checkme input[type='checkbox']").attr('checked', 'checked'); 
        }); 
   
        //$(".icon_general.icon_course_reserves").draggable(); 
   
        $("#tools_viewlog td:nth-child(6)").attr('style', 'white-space: pre;'); 
   
        //BEGIN lock club creation to logged in branch + other branches in district 
        if (window.location.href.indexOf("clubs-add-modify.pl") > -1) { 
          $('#clubs_add_modify option[value=' + loglibbc + ']').attr('selected', 'selected'); 
          $('#clubs_add_modify option[value!=' + loglibbc + ']').hide(); 
          $('#clubs_add_modify option[value^=' + sloglibbc + ']').show(); 
        } 
   
   
   
        if (url.indexOf("guarantor_search.pl") != -1) { 
          $('#categorycode_filter option[value="ADULT"]').attr('selected', 'selected'); 
          $('#categorycode_filter option[value=""], #categorycode_filter option[value^="A_SELF"], #categorycode_filter option[value^="ASSOCIATE"], #categorycode_filter option[value^="BOOKCLUB"], #categorycode_filter option[value^="CHILD"], #categorycode_filter option[value^="ILL"], #categorycode_filter option[value^="OSAW-STUD"], #categorycode_filter option[value^="OTHERCHILD"], #categorycode_filter option[value^="STAFF"], #categorycode_filter option[value^="TEACHER"]').remove(); 
          $('#branchcode_filter option[value^="DIGITAL"]').remove(); 
        } 
   
        //BEGIN Resize guarantor search window 
        if (document.location.href.indexOf('guarantor_search.pl') > -1) window.moveTo(0, 0), window.resizeTo((screen.width * 0.9), (screen.height * 0.9)); 
   
        //BEGIN remove recursive links in cover images with COCE 
        $('#catalog_detail #bookcoverimg .p1').removeAttr("href"); 
   
        $('#default-circulation-rules tr td:nth-child(1):contains("All"), #default-circulation-rules tr td:nth-child(2):contains("All")').css('background', '#ffb3ff'); 
   
        //COVID19 closures 
   
        $('.closed').parent().hover(function() { 
          $('body, .closed').css('background-color', '#ffff99'); 
        }, function() { 
          $('.closed').css('background-color', '#E6F0F2'); 
          $('body').css('background-color', '#ffffff'); 
        }); 
   
        $('#passcode1').on("click", function() { 
          value = $(this).data('clipboard-text'); //Upto this I am getting value 
   
          var $temp = $("<input>"); 
          $("body").append($temp); 
          $temp.val(value).select(); 
          document.execCommand("copy"); 
          $temp.remove(); 
        }); 

        $('#tools_batchMod #barcode_file').removeAttr('checked'); 
        $('#tools_batchMod #itemid_file').attr('checked', 'checked'); 
        $('#tools_batchMod-del #del_records').attr('checked', 'checked'); 
   
        $('.NEKLS #reserves').on('init.dt', function() { 
          $("td:contains('Suspend')").attr('style', 'background-color: yellow !important;'); 
          $('#suspend-modal-until').val('03/12/2023'); 
          $('#suspend_until').val('03/12/2023'); 
        }); 
   
      $('#pat_memberentrygen #selections'); 
   
      $('#pat_memberentrygen #selections:contains("Guarantor information |")') 
        .contents() 
        .filter(function() { 
          return this.nodeType == Node.TEXT_NODE; 
      }).wrap("<p class='collapsed_description'>"); 
   
        $('.collapsed_description').each(function() { 
          var text = $(this).text(); 
          $(this).text(text.replace('Guarantor information |', '')); 
        }); 
   
      //fixes tinymce news block mangling 
      $("#main_intranet-main #area-news").one("mouseenter", function(e){ 
         $("#main_intranet-main #area-news a").each(function() { 
          this.href = this.href.replace('/cgi-bin/reports', '/cgi-bin/koha/reports'); 
         }); 
      }); 
   
      //Embiggen item search fields 
        $('#catalog_itemsearch #itemsearchform select[multiple="multiple"]').attr('size', '50%'); 
   
      //Hide unused "Young Adult" locations 
        $('#catalog_itemsearch #location option[value="YOUNGADULT"], #catalog_itemsearch #location option[value="BALDYA"], #catalog_itemsearch #location option[value="LVPLYA"], #catalog_itemsearch #location option[value="PAOLAYA"]').hide(); 
   
   
      //Sort menus in item search 
      if ( $('#catalog_itemsearch').length ) { 
          sortMenus('itype'); 
        sortMenus('location'); 
          sortMenus('ccode'); 
          sortMenus('notforloan'); 
          sortMenus('itemlost'); 
      } 
   
      //BEGIN Prevent leading and trailing whitespace on list name 
        $('#lists_shelves #shelfname').bind("keypress", function(e) { 
        if (e.keyCode == 13) { 
          e.preventDefault(); 
          return false; 
        } 
      }); 
       $('#lists_shelves #shelfname').on('blur', function() { 
        $(this).val(function(i, value) { 
         return value.replace(/(?<!\d)[^a-zA-Z 0-9](?!\d)/g, '').replace(/\s+/g, ' ').trim(); 
        }); 
       }); 
   
      //BEGIN Prevent leading and trailing whitespace on item record - remove doublespaces 
       $('#cat_additem .input_marceditor').on('blur', function() { 
           $(this).val(function(i, value) { 
           return value.replace(/\s+/g, ' ').trim(); 
           }); 
       }); 
   
      $('#admin_smart-rules #defaults-for-this-library td').last().append('<br /><button id="rudefault" class="btn btn-default btn-xs">Load defaults</button>'); 
   
      $('#rudefault').click(function() { 
        event.preventDefault(); 
        $('#defaults-for-this-library > form:nth-child(3) > table:nth-child(3) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > input:nth-child(1)').val('100'); 
        $('#defaults-for-this-library > form:nth-child(3) > table:nth-child(3) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(3) > input:nth-child(1)').val('100'); 
        $('#defaults-for-this-library > form:nth-child(3) > table:nth-child(3) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(4) > input:nth-child(1)').val('1000'); 
        $('#defaults-for-this-library > form:nth-child(3) > table:nth-child(3) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(5) > select:nth-child(1) > option:nth-child(2)').attr('selected','selected'); 
        $('#defaults-for-this-library > form:nth-child(3) > table:nth-child(3) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(6) > select:nth-child(1) > option:nth-child(2)').attr('selected','selected'); 
        $('#defaults-for-this-library > form:nth-child(3) > table:nth-child(3) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(7) > select:nth-child(1) > option:nth-child(2)').attr('selected','selected'); 
      }); 
   
      //$('#memberentry_identity').before('<fieldset id="memberentry_patron_attributes" class="rows"><div id="xfactor"></div></fieldset>'); 
   
   
        $("#aai_EXPIRED").insertBefore($("#memberentry_identity")); 
   
      $('#aai_EXPIRED, #aai_School, #aai_Holdscon, #aai_Location, #aai_Permissions, #aai_COLLECT, #aai_PREF').on('click', '.clear_attribute', function(e){ 
          e.preventDefault(); 
          clear_entry( this ); 
      }); 
   
        //BEGIN Create button to make the renewal period match the issuelength 
        $('#tools_modborrowers #cataloguing_additem_newitem .attributes').append("<br /><button id='deletegroup' type='button' style='margin: 5px' class='btn btn-default btn-xs'>Set for deletion</button>"); 
        $("#deletegroup").click(function() { 
          $('input[name="surname"], input[name="firstname"]').val('Deleted'); 
          $('input[name="dateexpiry"]').val('1900-01-01'); 
          $('input[value="streetnumber"], input[value="address"], input[value="address2"], input[value="country"], input[value="email"], input[value="phone"], input[value="mobile"], input[value="borrowernotes"], input[value="opacnote"], input[value="debarred"], input[value="debarredcomment"]').attr('checked','checked'); 
        }); 
   
      $('#tools_upload #uploadresults tr').each(function() { 
          var kohafile = $(this).find('td:eq(0)').text(); 
          var hashval = $(this).find('td:eq(2)').text(); 
          if ($(this).find('td:eq(3)').text() == 'IMG') { 
            $(this).find('td:eq(0)').html('<i class="fa fa-link" aria-hidden="true"></i> <a target="_blank" href="https://nextkansas.org/images/' + hashval + '_' + kohafile + '">' + kohafile + '</a>'); 
          } 
      }); 
   
      //ATCHISON specific 
       //Adds class to KANOPY allowed attribute 
       $('.ATCHISON label:contains("Kanopy (ATCHISON):")').parent().addClass('ATCHISONkanopy'); 
       //Adds Kanopy allowed value to new patrons created at LEAVENWRTH only on new users 
       var url = $(location).attr('href'); 
       if (url.indexOf("memberentry.pl?op=add") != -1) { 
         $('.ATCHISONkanopy select option[value=ATCHISON]').attr("selected", "selected"); 
       } 
       //Changes to Kanopy not allowed when home library is changed to not-ATCHISON 
       $('.ATCHISON #libraries').change(function() { 
         $('.ATCHISONkanopy select option[value="0"]').attr("selected", "selected"); 
       }); 
       //Changes to Kanopy allowed when home library is changed to ATCHISON 
       $('.ATCHISON #libraries option[value=ATCHISON]').click(function() { 
         $('.ATCHISONkanopy select option[value=ATCHISON]').attr("selected", "selected"); 
       }); 
   
      //BASEHOR specific 
        //Adds class to KANOPY allowed attribute 
          $('.BASEHOR label:contains("Kanopy (BASEHOR):")').parent().addClass('BASEHORkanopy'); 
        //Adds Kanopy allowed value to new patrons created at xxx only on new users 
          var url = $(location).attr('href'); 
          if (url.indexOf("memberentry.pl?op=add") != -1) { 
            $('.BASEHORkanopy select option[value=BASEHOR]').attr("class", "bob"); 
          } 
        //Changes to Kanopy not allowed when home library is changed to not-BASEHOR 
          $('.BASEHOR #libraries').change(function() { 
            $('.BASEHORkanopy select option[value="0"]').attr("selected", "selected"); 
          }); 
        //Changes to Kanopy allowed when home library is changed to xxx 
          $('.BASEHOR #libraries option[value=BASEHOR]').click(function() { 
            $('.BASEHORkanopy select option[value=BASEHOR]').attr("selected", "selected"); 
          }); 
   
         $('#circ_circulation').each(function() { 
          if ($(".patroncategory:contains(Digital)", this).length && $("#circ_needsconfirmation", this).length) { 
            $('.patroncategory').css('background', 'pink').wrap('<h2></h2>'); 
            $('#circ_needsconfirmation .approve').attr('disabled','disabled'); 
            $('#circ_needsconfirmation .deny').after('<h2 style="background: pink;">You cannot check out physical items to a borrower with a \"DIGITAL ONLY\" borrower category<br /><a href="https://northeast-kansas-library-system.github.io/next/borrowers/categories_digital_only.html#circulation-override-disabled" target="_blank">Click here for more information</h2>'); 
            alert('\"DIGITAL ONLY\" account holders are not allowed to check out physical materials'); 
          } 
        }); 
   
      $('#patron_updates_pending').wrapInner('<span id="all_patron_mods" />'); 
      if ($('#patron_updates_pending').length) { 
   
        //$('#all_patron_mods').append($('.logged-in-branch-code').first().html()); 
   
      } 
   
      $('.NEKLS .select_city option:contains("Kansas City")').click(function(){ 
   
        alert("There are 10 Zip Codes for KCK - Please be sure you are selecting the correct one"); 
   
      }); 
   
      $('#cat_z3950_search input').click(function() { 
        $('#z3950_119').prop("checked", true); 
      }); 
      $('#resultst').on('init.dt', function() { 
          $(this).dataTable().fnSort([$(this).find('tr[role=row] th:contains("Server")').index('th'), 'asc']); 
        }); 
   
   
   
      $('#cat_z3950_search td:contains("NEXT SEARCH CATALOG (NEKLS)")').each(function(  ) { 
        $(this).parent().addClass('topgun'); 
        $('.topgun td').attr('style', 'background-color: #ffffb3;'); 
        $('body').attr('style','background-color: #ffe6ea;'); 
        $('h2:contains("Results")').first().addClass('duplicate_z_warning'); 
      }); 
   
        $('.duplicate_z_warning').append("<div class='dialog' style='background-color: yellow;'><i class='fa fa-exclamation-triangle' style='padding-right: 2%' aria-hidden='true'></i>&nbsp;Search result matches at least one existing record in Next Search Catalog.&nbsp;<i class='fa fa-exclamation-triangle' style='padding-left: 2%' aria-hidden='true'></i><br />Please recheck the catalog to confirm you\'re not creating a duplicate record.<br /><br />This doesn't mean you can't import a record,<br />just that you should double check to make sure you're not adding a duplicate.</div>"); 
   
      if( $('#pat_member-password').length ) { 
        //Create buttons 
   
        $('#newuserid').after('<div class="btn-group ezfill" style="padding-left: 15px;"><button class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="true" >Username options <span class="caret"></span></button><ul class="dropdown-menu "><li><a id="cardid_refill">Use library card number for username</a></li><li><a id="nameid_refill">Use firstname.lastname for username (Next default)</a></li></ul></div>'); 
   
        $('#newpassword2').after('<div class="btn-group ezfill" style="padding-left: 15px;"><button class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-expanded="true">Password options <span class="caret"></span></button><ul class="dropdown-menu "><li><a id="lnamepass_refill">Use last name for password (case sensitive)</a></li><li><a id="phonepass_refill">Use last 4 digits of phone for password</a></li><li><a id="townpass_refill">Use name of town in lowercase letters</a></li><li><a id="birthpass_refill">Use birthdate in format MMDDYYYY (no / marks)</a></li></ul></div>'); 
   
        var usrBorrowerNumber = $('#borrowernumber').val(); 
        //Get patron data 
        var url = '/api/v1/patrons?patron_id=' + usrBorrowerNumber; 
        let patronInfoArr; 
        $.ajax({ 
            async: false, 
            url: url, 
            success: function(data) { 
              patronInfoArr = [data[0].firstname, data[0].surname, data[0].cardnumber, data[0].phone, data[0].city, data[0].date_of_birth]; 
            } 
        }); 
        //Set button functions 
        $('#nameid_refill').on('click', function() { 
          $('#newuserid').val(patronInfoArr[0].toLowerCase()+"."+patronInfoArr[1].toLowerCase()); 
        }); 
        $('#cardid_refill').on('click', function() { 
          $('#newuserid').val(patronInfoArr[2]); 
        }); 
        $('#lnamepass_refill').on('click', function() { 
            $('#newpassword,#newpassword2').val(patronInfoArr[1]); 
        }); 
        $('#phonepass_refill').on('click', function() { 
            $('#newpassword,#newpassword2').val(patronInfoArr[3].slice(-4)); 
        }); 
        $('#townpass_refill').on('click', function() { 
            $('#newpassword,#newpassword2').val(patronInfoArr[4].toLowerCase()); 
        }); 
        $('#birthpass_refill').on('click', function() { 
            $('#newpassword,#newpassword2').val((patronInfoArr[5].slice(5,7))+(patronInfoArr[5].slice(8,10))+(patronInfoArr[5].slice(0,4))); 
        }); 
      } 
   
      $('.ezfill').mouseover(function() { 
        $(this).addClass("open"); 
      }); 
   
      $('#tools_scheduler #format option[value="csv"]').attr("selected","selected"); 
    
      var report_selected = $('#tools_scheduler #report option[selected="selected"]').val();
      $('#tools_scheduler #report option[selected="selected"]').val(report_selected + ' --csv-header -a');
      console.log('report_selected: ', + report_selected);
   
      //Import data from Photo ID 
        $('#pat_memberentrygen #toolbar').append('<button class="btn btn-default toggler" id="btnScanPhotoID" name="scan" style="margin-right: 0px; margin-right: 5px;"><i class="fa fa-id-card-o"></i> Scan Photo ID</button>'); 
        $('#pat_memberentrygen').append('<div id="PhotoIDModal" class="modal fade" role="dialog" aria-hidden="true"><div class="modal-dialog"><div class="modal-content"><form id="formID" method="post" action="submit" onsubmit="return false;"><div class="modal-header"><h3>Scan Photo ID</h3></div><div class="modal-body"><textarea id="inputPhotoIDData" rows="1" cols="1" style="margin-left: -400px;" /><span id="msgScan"></span></div><div id="ContentFooter" class="modal-footer"><button id="btnPhotoIDClose" data-dismiss="modal" aria-hidden="true" class="btn"><i class="fa fa-times"></i> Cancel</button></div></form></div></div></div>'); 
        function ProcessPhotoID() { 
          //Close modal 
          $('#PhotoIDModal').modal('hide'); 
          $('#PhotoIDModal').on('hidden.bs.modal', function () { 
            $('#msgScan').html('<h4>Scan Photo ID now...</h4>'); 
          }); 
          //Separate information into array 
          console.log($('#inputPhotoIDData').val()); 
          var IDSegments = $('#inputPhotoIDData').val().split('\n'); 
   
          function toTitleCase(str) 
          //NEED TO MAKE THIS FUNCTION OPTIONAL 
          { 
            return str.replace(/\w\S*/g, function(txt){return txt.charAt(0).toUpperCase() + txt.substr(1).toLowerCase();}); 
          } 
          //Fix city names that are incomplete 
          function FixCity(str) { 
            if (str == 'Coeur D Al') { 
              return 'Coeur d\'Alene'; 
            } else { 
              return str; 
            } 
          } 
          //Process data 
          if (IDSegments != '') { 
            var usrLastName,usrFirstName,usrBirth,mStop,usrMailingAddress,usrMailingCity,usrMailingState,usrMailingZip,usrPhysicalAddress,usrPhysicalCity,usrPhysicalState,usrPhysicalZip; 
            for (i = 0; i < IDSegments.length; ++i) { 
              if (IDSegments[i].startsWith('DCS')) { 
                usrLastName = toTitleCase(IDSegments[i].slice(3)); 
                if (usrLastName.substring(0,2) == 'Mc') { 
                  usrLastName = 'Mc' + usrLastName.substring(2,3).toUpperCase() + usrLastName.substring(3); 
                } 
                if (usrLastName.substring(0,3) == 'Mac') { 
                  $('label[for="surname"]').siblings('span.required').after('<span style="background-color: yellow; color: red; margin-left: 5px;"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i> Check capitalization</span>'); 
                } 
              } 
              if (IDSegments[i].startsWith('DAC')) { 
                usrFirstName = toTitleCase(IDSegments[i].slice(3)); 
              } 
              if (IDSegments[i].startsWith('DAD')) { 
                usrFirstName += ' ' + toTitleCase(IDSegments[i].slice(3)); 
              } 
              if (IDSegments[i].startsWith('DBB')) { 
                usrBirth = IDSegments[i].slice(3); 
                usrBirth = usrBirth.substring(0,2) + '/' + usrBirth.substring(2,4) + '/' + usrBirth.substring(4,8); 
              } 
              if (IDSegments[i].startsWith('DAG')) { 
                usrMailingAddress = toTitleCase(IDSegments[i].slice(3)); 
              } 
              if (IDSegments[i].startsWith('DAH')) { 
                usrMailingAddress += ' ' + toTitleCase(IDSegments[i].slice(3)); 
              } 
              if (IDSegments[i].startsWith('DAI')) { 
                usrMailingCity = FixCity(toTitleCase(IDSegments[i].slice(3))); 
              } 
              if (IDSegments[i].startsWith('DAJ')) { 
                usrMailingState = IDSegments[i].slice(3); 
              } 
              if (IDSegments[i].startsWith('DAK')) { 
                usrMailingZip = toTitleCase(IDSegments[i].slice(3,8)); 
              } 
              if (IDSegments[i].startsWith('DAL')) { 
                usrPhysicalAddress = toTitleCase(IDSegments[i].slice(3)); 
              } 
              if (IDSegments[i].startsWith('DAM')) { 
                usrPhysicalAddress += ' ' + toTitleCase(IDSegments[i].slice(3)); 
              } 
              if (IDSegments[i].startsWith('DAN')) { 
                usrPhysicalCity = FixCity(toTitleCase(IDSegments[i].slice(3))); 
              } 
              if (IDSegments[i].startsWith('DAO')) { 
                usrPhysicalState = IDSegments[i].slice(3); 
              } 
              if (IDSegments[i].startsWith('DAP')) { 
                usrPhysicalZip = toTitleCase(IDSegments[i].slice(3,8)); 
              } 
            } 
            //Copy data to form fields 
            $('#surname').val(usrLastName).css('background-color','yellow'); 
            $('#firstname').val(usrFirstName).css('background-color','yellow'); 
            $('#dateofbirth').val(usrBirth).css('background-color','yellow'); 
            $('#address').val(usrMailingAddress).css('background-color','yellow'); 
            $('#city').val(usrMailingCity).css('background-color','yellow'); 
            $('#state').val(usrMailingState).css('background-color','yellow'); 
            $('#zipcode').val(usrMailingZip).css('background-color','yellow'); 
            //If secondary address doesn't exist, it usually starts with @ 
            if (typeof usrPhysicalAddress != 'undefined') { 
              $('#B_address').val(usrPhysicalAddress).css('background-color','yellow'); 
              $('#B_city').val(usrPhysicalCity).css('background-color','yellow'); 
              $('#B_state').val(usrPhysicalState).css('background-color','yellow'); 
              $('#B_zipcode').val(usrPhysicalZip).css('background-color','yellow'); 
            } 
          } 
        } 
        $('#pat_memberentrygen #btnScanPhotoID').on('click', function() { 
          var TimerActive = 0; //Reset timer 
          var ScanActive = 0; 
          $('#inputPhotoIDData').val(''); 
          $('#msgScan').html('<h4>Scan Photo ID now...</h4>'); 
          $('#PhotoIDModal').modal('show'); 
          $('#PhotoIDModal').on('shown.bs.modal', function () { 
            $('#inputPhotoIDData').focus(); 
            $('#inputPhotoIDData').unbind(); 
            $('#inputPhotoIDData').keydown(function(event){ 
              var code = (event.keyCode || event.which); 
              if(event.keyCode == 13) { 
                event.preventDefault(); 
                return false; 
              } 
              if (code == 120) { //Disable F9 so Firefox doesn't launch reader 
                return false; 
              } 
            }); 
            $('#inputPhotoIDData').on('keyup', function() { 
              if (ScanActive == 0) { //Set Processing Message 
                $('#msgScan').html('<center><h4>Processing...  please wait.</h4><img src="https://nextkansas.org/images/c6218595e2fe6b3484f0e8653fdbcc74_notable.svg" height="50px"></center>'); 
                ScanActive = 1; 
              } 
              if (TimerActive == 0) {  //Time's up on input 
                TimerActive = 1; 
                setTimeout(function(){ 
                  console.log('Entire block of data: '); 
                  console.log($('#inputPhotoIDData').val()); 
                  var checkStart = $('#inputPhotoIDData').val().startsWith('@'); //Check if beginning of barcode starts with @ 
                  if (checkStart) { //Was this a valid barcode? 
                    ProcessPhotoID(); 
                  } else { 
                    $('#msgScan').html('<center><h4>That doesn\'t look like a Photo ID.  Try again.</h4></center>'); 
                    $('#inputPhotoIDData').val(''); 
                    TimerActive = 0; 
                    ScanActive = 0; 
                  } 
                }, 5000); 
              } 
              console.log(event.key); 
              //Convert to linefeed - ArrowDown for Honeywell 7580g / ArrowRight for Datalogic QD2430 / Alt for Zebra Symbol DS4308 
              if ((event.key == 'ArrowDown') || (event.key == 'ArrowRight') || (event.key == 'Alt')) { 
                $('#inputPhotoIDData').val($('#inputPhotoIDData').val() + '\n'); 
              } 
            }); 
          }); 
        }); 
        //END Import data from Photo ID 
   
  
   
      $('#circ_circulation #toolbar, #pat_moremember #toolbar').append('<a id="card_print" class="btn btn-default">Print card number</a>'); 
   
      //BEGIN adds function onto the print button 
      $("#card_print").click(function() { 
        var barcode_cont = $(".patroninfo h5").first().text().trim().match(/(?<=\()[^()]+?(?=\)*$)/g); 
        var problemWindow = window.open('', '', 'height=500,width=500'); 
        problemWindow.document.write('<html><head><style>body {width: 260px; padding-bottom: 10px; word-wrap: break-word} input {display: none;}</style><title></title></head><body><div><h2>=====<br />&nbsp;<br />'); 
        problemWindow.document.write(barcode_cont); 
        problemWindow.document.write('<br />&nbsp;<br />=====</h2>'); 
   
        problemWindow.document.close(); 
   
        problemWindow.onload = function() { 
          problemWindow.focus(); 
          problemWindow.print(); 
          problemWindow.close(); 
        }; 
      }); 
   
   
      $('#claims-returned-modal-btn-submit').click(function() { 
        $('#claims-returned-notes').val(function(index, val) { 
          return val + ' - Marked as "Claims returned" by ' + ($('.loggedinusername').html().trim()) + ' at ' + ($(".logged-in-branch-code").html().trim()); 
        }); 
      }); 
   
      var url1 = $(location).attr('href'); 
      var bcode1 = $('.logged-in-branch-code').first().text(); 
      if (url1.indexOf("label-edit-layout.pl?op=new") != -1) { 
        $('.action > input:nth-child(1)').one("click", function() { 
          $('#layout_name').val(function(index, val) { 
            return bcode1 + " " +  val 
          }); 
        }); 
      } 
   
      //Administration > Circulation and fine rules 
        //BEGIN rename "All" to "All borrowers" 
          $('#default-circulation-rules').on('init.dt', function() { 
            //Change "All" to "All borrowers" 
              $('#default-circulation-rules tr td:nth-child(1) em:contains("All")').html('All borrowers'); 
            //Click on row to move it to bottom 
              $("#default-circulation-rules tr:contains(Edit)").click(function() { 
                $(this).insertBefore("#default-circulation-rules #edit_row"); 
              }); 
            //BEGIN Highligh rows containing "All" 
              $('#default-circulation-rules tr td:nth-child(1):contains("All"), #default-circulation-rules tr td:nth-child(2):contains("All")').css('background', '#ffb3ff'); 
            //BEGIN Highlight row on hover 
              $("#default-circulation-rules tr").hover( 
                function() { 
                  $(this).addClass("highlighted-row"); 
                }, 
                function() { 
                  $(this).removeClass("highlighted-row"); 
                } 
              ); 
            //BEGIN Hide unneeded columns in circulation rules by clicking on header (--requires corresponding css--) 
              $("#default-circulation-rules thead th").append("<br /><br /><span>Hide<br />Column</span>"); 
              $('#default-circulation-rules thead th').click(function() { 
                var index = (this.cellIndex + 1); 
                var cells = $('#default-circulation-rules tr > :nth-child(' + index + ')'); 
                cells.toggleClass('hiderule'); 
                if ($(this).hasClass('hiderule')) { 
                  $(this).find('span').html('+'); 
                } else { 
                  $(this).find('span').html('Hide<br />Column'); 
                } 
                if ($('table tr > th:not(.collapsed)').length) 
                  $('table').removeClass('collapsed'); 
                else 
                  $('table').addClass('collaps









