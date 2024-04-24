/* GroupName: TeamPRSTV (Preethi Ranganathan, Sindhuja Kodaparthi, Mary Rithika Reddy Gade, Tarun Vinay Gujjar, Vikas Halgar Seetharam) */

package com.example.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.repository")
public class JpaConfig {
}