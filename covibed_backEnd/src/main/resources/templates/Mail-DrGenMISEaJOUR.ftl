<!DOCTYPE html>
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Mise a jour des mot de pass</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
/**
   * Google webfonts. Recommended to include the .woff version for cross-client compatibility.
   */
@media screen {
    @font-face {
        font-family: 'Source Sans Pro';
        font-style: normal;
        font-weight: 400;
        src: local('Source Sans Pro Regular'), local('SourceSansPro-Regular'),
            url(https://fonts.gstatic.com/s/sourcesanspro/v10/ODelI1aHBYDBqgeIAH2zlBM0YzuT7MdOe03otPbuUS0.woff)
            format('woff');
    }
    @font-face {
        font-family: 'Source Sans Pro';
        font-style: normal;
        font-weight: 700;
        src: local('Source Sans Pro Bold'), local('SourceSansPro-Bold'),
            url(https://fonts.gstatic.com/s/sourcesanspro/v10/toadOcfmlt9b38dHJxOBGFkQc6VGVFSmCnC_l7QZG60.woff)
            format('woff');
    }
}
/**
   * Avoid browser level font resizing.
   * 1. Windows Mobile
   * 2. iOS / OSX
   */
header, body, table, td, a {
    -ms-text-size-adjust: 100%; /* 1 */
    -webkit-text-size-adjust: 100%; /* 2 */
}
/**
   * Remove extra space added to tables and cells in Outlook.
   */
table, td {
    mso-table-rspace: 0pt;
    mso-table-lspace: 0pt;
}
/**
   * Better fluid images in Internet Explorer.
   */
img {
    -ms-interpolation-mode: bicubic;
}
/**
   * Remove blue links for iOS devices.
   */
a[x-apple-data-detectors] {
    font-family: inherit !important;
    font-size: inherit !important;
    font-weight: inherit !important;
    line-height: inherit !important;
    color: inherit !important;
    text-decoration: none !important;
}
/**
   * Fix centering issues in Android 4.4.
   */
div[style*="margin: 16px 0;"] {
    margin: 0 !important;
}

body {
    width: 100% !important;
    height: 100% !important;
    padding: 0 !important;
    margin: 0 !important;
}
/**
   * Collapse table borders to avoid space between cells.
   */
table {
    border-collapse: collapse !important;
}

a {
    color: #1a82e2;
}

img {
    height: auto;
    line-height: 100%;
    text-decoration: none;
    border: 0;
    outline: none;
}

.td_conf_mail {
    padding: 36px 24px 0;
    font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif;
    border-top: 3px solid #d4dadf;
}

.title {
    margin: 0;
    font-family: 'Source Sans Pro';
    margin: 0;
    font-size: 32px;
    font-weight: 700;
    letter-spacing: -1px;
    line-height: 48px;
}

.welcome {
    padding: 24px;
    font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif;
    font-size: 16px;
    line-height: 24px;
}

.button_link {
    display: inline-block;
    padding: 12px 16px;
    font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif;
    font-size: 24px;
    color: #ffffff;
    text-decoration: none;
    border-radius: 6px;
}

.button_space {
    border-radius: 6px;
    padding: 12px 3px;
}
</style>

</head>
<body style="background-color: #e9ecef;">

    <!-- start preheader -->
    <div class="preheader"
        style="display: none; max-width: 0; max-height: 0; overflow: hidden; font-size: 1px; line-height: 1px; color: #fff; opacity: 0;">
        A preheader is the short summary text that follows the subject line
        when an email is viewed in the inbox.</div>
    <!-- end preheader -->

    <!-- start body -->
    <table border="0" cellpadding="0" cellspacing="0" width="100%">

        <!-- start logo -->
        <tr>
            <td align="center" bgcolor="#e9ecef">
                <table border="0" cellpadding="0" cellspacing="0" width="100%"
                    style="max-width: 600px;">
                    <tr>
                        <td align="center" valign="top" style="padding: 36px 24px;">
                        <td><a href="http://www.exis-it.com/Products.html"
                            target="_blank" style="display: inline-block;"> <!--                 <img src="../covibedImg.png" alt="Logo" border="0" width="50" style="display: block; width: 50px; max-width: 50px; min-width: 50px;"> -->
                        </a></td>
                        <td>
                            <h1 class="title">Covibed</h1>
                        </td>

                        </td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td align="center" bgcolor="#e9ecef">
                <table border="0" cellpadding="0" cellspacing="0" width="100%"
                    style="max-width: 600px;">
                    <tr>
                        <td align="center" bgcolor="#ffffff" class="td_conf_mail">
                            <h1 class="title" style="color: blue">Mise a jour  des mots de pass</h1>
                        </td>
                    </tr>
                </table> <br>
            </td>
        </tr>



        <tbody>
    </table>

    </tbody>
    <#list DATA as it>
          <table border="0" cellpadding="0" cellspacing="0" width="100%"
            style="max-width: 600px;">
            <tr>

                <td align="left" >
                         <p style="margin: 0;"><h3 >${it.orgName} </h3></p>
                    <#list it.services as its>
                    <table border="0" cellpadding="0" cellspacing="0" width="100%"
                        style="max-width: 600px;">
                        <tr>

                            <td align="left">
                                <p style="margin: 0;">
                                <h4>${its.srvNAme}</h4>
                            </p>




         <table align="center" border="0" cellpadding="0" cellspacing="0" width="100%"
                style="max-width: 600px;">

                <tr>
                    <td align="center" bgcolor="#ffffff">

                        <table border="0" cellpadding="0" cellspacing="0" width="100%">

                            <thead>
                                <tr>
                                    <th>Nom & Prenom</th>
                                    <th>Nom d'utilisateur</th>
                                    <th>Mot de pass</th>
                                </tr>
                            </thead>
                            <tBody>
                                <#list its.user as itu>

                                <tr align="center">
                                    <td>${itu.nom}</td>
                                    <td>${itu.username}</td>
                                    <td>${itu.password}</td>
                                </tr>

                                </#list>
                            </tBody>



                        </table>
                    </td>
                    <br>


                </tr>
            </table>


                            </td>

                            </td>
                        </tr>
                    </table>

                    </#list>


                </td>
            </tr>
        </table>

    </#list>
    <table border="0" cellpadding="0" cellspacing="0" width="100%">
        <td align="center" bgcolor="#e9ecef">



            <br> <br> <!-- end button -->
            <table border="0" cellpadding="0" cellspacing="0" width="100%">
                <!-- start copy -->
                <tr>
                    <td align="left" bgcolor="#ffffff"
                        style="padding: 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 16px; line-height: 24px; border-bottom: 3px solid #d4dadf">
                        <p style="margin: 0;">
                            Bien Cordialement,<br> <b>Equipe Covibed</b><br> <b>Email
                                : </b> <a
                                href="mailto:contact@exis-it.com?Subject=Support%20%Guide%20Des%20Urgences"
                                target="_top">contact@exis-it.com</a> <br> <b>Site web:</b>
                            <a href="http://www.exis-it.com" target="_blank">
                                http://www.exis-it.com
                        </p>
                    </td>
                </tr>
            </table> <!-- end copy -->
    </table>
    </td>
    <tr>
        <td align="center" bgcolor="#e9ecef" style="padding: 24px;">
            <table border="0" cellpadding="0" cellspacing="0" width="100%">

                <!-- start permission -->
                <tr>
                    <td align="center" bgcolor="#e9ecef"
                        style="padding: 12px 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 20px; color: #666;">
                        <p style="margin: 0;">Vous avez reçu cet e-mail, suite à la
                            mise a jour mensuel des mots de pass</p>
                    </td>
                </tr>
                <tr>
                    <td align="center" bgcolor="#e9ecef"
                        style="padding: 12px 24px; font-family: 'Source Sans Pro', Helvetica, Arial, sans-serif; font-size: 14px; line-height: 20px; color: #666;">
                        <p style="margin: 0;">
                            N'hésitez pas à nous contacter sur cette email adresse : <a
                                href="mailto:contact@exis-it.com?Subject=Support%20%Guide%20Des%20Urgences"
                                target="_top">contact@exis-it.com</a>
                        </p>
                        <center>
                            <strong>Expert Integrator Solution - EXIS</strong><br />
                            <p>
                                Copyright © 2015 by EXIS <a href="http://www.exis-it.com">
                                    www.exis-it.com</a>
                            </p>
                        </center>
                    </td>
                </tr>
                <!-- end unsubscribe -->

            </table>
        </td>
    </tr>
    <!-- end footer -->

    </table>
    <!-- end body -->

</body>
</html>